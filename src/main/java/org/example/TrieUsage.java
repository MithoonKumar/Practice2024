//package org.example;
//
//import java.util.*;
//
//public class TrieUsage {
//
//
//    public static void main(String[] args) {
//        int[] arr = {1, 5,4,3,2,1};
//        TreeMap<Integer, Integer> treeSet = new TreeMap<>();
//        treeSet.put(1, 1);
//        System.out.println(treeSet.las);
//        System.out.println(treeSet.getLast());
//    }
//}
//
//
//class Trie {
//
//    public TrieNode trieNode ;
//
//    public Trie() {
//        this.trieNode = new TrieNode();
//    }
//
//    public void insert(String str) {
//        TrieNode node = trieNode;
//        for (int i=0; i<str.length(); i++) {
//            char ch = str.charAt(i);
//            int index = ch - 'a';
//            if (node.children[index] == null) {
//                node.children[index] = new TrieNode();
//            }
//            node = node.children[index];
//        }
//        node.isEndOfWord = true;
//    }
//
//    public boolean search(String str) {
//        TrieNode node = trieNode;
//        for (int i=0; i<str.length(); i++) {
//            int index = str.charAt(i) - 'a';
//            if (node.children[index] == null) {
//                return false;
//            }
//            node = node.children[index];
//        }
//        return node.isEndOfWord;
//    }
//
//
//    public boolean startsWith(String prefix) {
//        TrieNode node = trieNode;
//        for (int i=0; i<prefix.length(); i++) {
//            int index = prefix.charAt(i) - 'a';
//            if (node.children[index] == null) {
//                return false;
//            }
//            node = node.children[index];
//        }
//        return true;
//    }
//}
//
//class TrieNode {
//    public TrieNode[] children = new TrieNode[26];
//    public boolean isEndOfWord = false;
//
//    public TrieNode() {
//        for (int i=0; i<26; i++) {
//            children[i] = null;
//        }
//    }
//
//}
//
//
//class Solution {
//    public int longestSubarray(int[] nums, int limit) {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        int sIndex = 0;
//        int ans = 1;
//        treeMap.put(nums[0], treeMap.getOrDefault(nums[0], 0)+1);
//        for (int i=1; i<nums.length; i++) {
//            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0)+1);
//            int min = treeMap.firstKey();
//            int max = treeMap.lastKey();
//            if (max - min > limit) {
//                while (true) {
//                    int num = nums[sIndex];
//                    if (treeMap.get(num) == 1) {
//                        treeMap.remove(num);
//                    } else {
//                        treeMap.put(num, treeMap.get(num)-1);
//                    }
//                    int min = treeMap.firstKey();
//                    int max = treeMap.lastKey();
//                    sIndex++;
//                    if (max - min <= limit) {
//                        break;
//                    }
//                }
//            } else {
//                ans = Math.max(ans, i-sIndex+1);
//            }
//        }
//        return ans;
//    }
//}
//
//
//
//class Interval implements Comparable<Interval>{
//    public sTime, eTime;
//    public Interval(int sTime, int eTime) {
//        this.sTime = sTime;
//        this.eTime = eTime;
//    }
//
//    @Override
//    public int compareTo(Interval o) {
//        return 0;
//    }
//
//}