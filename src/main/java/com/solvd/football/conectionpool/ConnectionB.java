package com.solvd.football.conectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionB {
    private static Logger logger = LogManager.getLogger(ConnectionB.class);

    private final Queue<Connection> availableConnections;
    private final Set<Connection> inUseConnections;

    public ConnectionB(int poolSize) {
        availableConnections = new ConcurrentLinkedQueue<Connection>();
        inUseConnections = ConcurrentHashMap.newKeySet();

        // add connections to the queue
        for (int i = 0; i < poolSize; i++) {
            availableConnections.offer(new Connection());
        }
    }

    public CompletionStage<Connection> getConnection() {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (availableConnections) {
                while (availableConnections.isEmpty()) {
                    try {
                        availableConnections.wait();
                    } catch (InterruptedException e) {
                        logger.info("Connection Failed: " + e);
                    }
                }

                Connection connection = availableConnections.poll();
                inUseConnections.add(connection);
                return connection;
            }
        });
    }

    public CompletionStage<Void> releaseConnection(Connection connection) {
        return CompletableFuture.runAsync(() -> {
            synchronized (availableConnections) {
                inUseConnections.remove(connection);
                availableConnections.offer(connection);
                availableConnections.notifyAll();
            }
        });
    }

    public CompletionStage<Void> close() {
        return CompletableFuture.runAsync(() -> {
            for (Connection connection : availableConnections) {
                connection.close();
            }
            for (Connection connection : inUseConnections) {
                connection.close();
            }
        });
    }
}
