package org.Google;


class Node {
    String value;
    int hashValue;
    Node next;

    public Node(String value, int hashValue, Node next) {
        this.value = value;
        this.hashValue = hashValue;
        this.next = next;
    }
}
