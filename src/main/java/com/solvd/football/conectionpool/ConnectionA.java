package com.solvd.football.conectionpool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ConnectionA {

    private final BlockingQueue<Connection> availableConnections;
    private final Set<Connection> inUseConnections;
    private final ThreadPoolExecutor executor;

    public ConnectionA(int poolSize) {
        availableConnections = new ArrayBlockingQueue<Connection>(poolSize);
        inUseConnections = new HashSet<>();

        for (int i = 0; i < poolSize; i++) {
            availableConnections.add(new Connection());
        }

        executor = new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    public synchronized Connection getConnection() throws InterruptedException {
        while (availableConnections.isEmpty()) {
            wait();
        }

        Connection connection = availableConnections.poll();
        inUseConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        inUseConnections.remove(connection);
        availableConnections.offer(connection);
        // Notify waiting threads that a connection is available
        notifyAll();
    }

    public void close() {
        for (Connection connection : availableConnections) {
            connection.close();
        }
        for (Connection connection : inUseConnections) {
            connection.close();
        }

        executor.shutdown();
    }
}
