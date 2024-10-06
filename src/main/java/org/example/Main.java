package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
//        linkedList.add(4, "Fourth");
        System.out.println(linkedList);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("World");
        System.out.println(hashSet.contains("Hell"));


        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.pop();
        stack.peek();


        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.poll();

    }
}



class Solution {

    public boolean checkForSameMap(HashMap<Character, Integer> firstMap, HashMap<Character, Integer> secondMap) {
        for(Map.Entry<Character, Integer> entry: firstMap.entrySet()) {
            if (!Objects.equals(secondMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> characterIntegerHashMap1 =  new HashMap<>();
        HashMap<Character, Integer> characterIntegerHashMap2 =  new HashMap<>();
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }
        for (int i=0; i<len1; i++) {
            Character character = s1.charAt(i);
            characterIntegerHashMap1.put(character, characterIntegerHashMap1.getOrDefault(character, 0) + 1);
        }

        for (int i=0; i<len1; i++) {
            Character character = s2.charAt(i);
            characterIntegerHashMap2.put(character, characterIntegerHashMap2.getOrDefault(character, 0) + 1);
        }
        if (checkForSameMap(characterIntegerHashMap1, characterIntegerHashMap2)) {
            return true;
        }

        for (int i=len1; i<len2; i++) {
            Character character1 = s2.charAt(i-len1);
            Character character2 = s2.charAt(i);
            characterIntegerHashMap2.put(character1, characterIntegerHashMap2.get(character1)-1);
            characterIntegerHashMap2.put(character2, characterIntegerHashMap2.getOrDefault(character2, 0) + 1);
            if (checkForSameMap(characterIntegerHashMap1, characterIntegerHashMap2)) {
                return true;
            }
        }
        return false;


    }
}