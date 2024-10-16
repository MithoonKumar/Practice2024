//package org.example;
//
//import java.util.HashMap;
//
//public class Test2 {
//
//    public static void main(String[] args) {
//        HashMap<Integer, Node1> hashMap = new HashMap<>();
//
//        Node1 node1 = new Node1(null, null, 0);
//        recurse(node1, hashMap, 0);
//
//    }
//
//    public static void recurse(Node1 node1, HashMap<Integer, Node1> hashMap, int level) {
//        if (node1.left == null && node1.right == null) {
//            return;
//        }
//
//        if (node1.left != null) {
//            recurse(node1.left, hashMap, level+1);
//        }
//        hashMap.put(level, );
//        if (node1.right != null) {
//            recurse(node1.right, hashMap, level + 1);
//        }
//    }
//}
//
//class Node1 {
//    Node1 left, right;
//    int val;
//
//    public Node1(Node1 left, Node1 right, int val) {
//        this.left = left;
//        this.right = right;
//        this.val = val;
//    }
//}
