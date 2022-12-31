package com.solvd.football.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T> {

    private static Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);

    Node<T> head;

    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public void insertAtStart(T data) {
        Node<T> newNode = new Node<T>(data);

        newNode.next = head;
        head = newNode;
    }

    public void insertAt(int index, T data) {
        if (index == 0) {
            insertAtStart(data);
        } else {
            Node<T> newNode = new Node<T>(data);

            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    public void show() {
        Node<T> currentNode = head;
        if (currentNode == null) {
            LOGGER.info("Linked list is empty");
        } else {
            while (currentNode != null) {
                LOGGER.info(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }
}
