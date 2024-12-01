package org.Google;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureLinkedList {
    private Node head;


    public SecureLinkedList() {
        head = null;
    }


    public void addNode(String value) {
        int currHashValue = computeHash(this.head, value);
        Node node = new Node(value, currHashValue, head);
        head = node;
    }

    private int computeHash(Node nextNode, String currValue) {
        Integer nextNodeHashValue = nextNode == null ? null : nextNode.hashValue;
        return this.hash(currValue + (nextNodeHashValue == null ? "" : nextNodeHashValue));
    }

    public boolean isValidChain() {
        Node iterator = head;
        while(iterator != null) {
            String value = iterator.value;
            System.out.println("value: " + value);
            int hashValue = iterator.hashValue;
            int expectedCurrHashValue = computeHash(iterator.next, value);
            if (hashValue != expectedCurrHashValue) {
                return false;
            }
            iterator = iterator.next;
        }
        return true;
    }



    private int hash(String data) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte [] hashBytes = digest.digest(data.getBytes());
        int hash = 0;
        for (int i=0; i<Math.min(4, hashBytes.length); i++) {
            hash = (hash << 8) | (hashBytes[i] & 0xFF);
        }
        return hash;
    }



}

