package org.example;


import java.util.*;

public class AnotherExperimentClass {

    public static void main(String[] args) {
//        int[] arr = {0,1,0,3,12};
//        moveZeroes(arr);
//        for (int i=0; i<arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
        System.out.println(linkedHashMap);
        linkedHashMap.pollFirstEntry();
        System.out.println(linkedHashMap);
    }

    private static void swapNums(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void moveZeroes(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                treeSet.add(i);
                continue;
            }
            if (nums[i] != 0 && treeSet.isEmpty()) {
                continue;
            }
            int top = treeSet.first();
            treeSet.removeFirst();
            treeSet.add(i);
            swapNums(top, i, nums);
        }
    }
}