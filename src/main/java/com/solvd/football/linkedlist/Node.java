package com.solvd.football.linkedlist;

public class Node<T> {

    T data; // Data in the current node
    Node<T> next; // Reference for the next node

    // Constructor which takes an int value which is stored as the data in this Node
    // object.
    Node(T data) {
        this.data = data;
    }
}
