package org.example;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*
Given are N boards of with length of each given in the form of array, and K painters, such that each painter takes 1 unit of time to paint 1 unit of the board. The task is to find the minimum time to paint all boards under the constraints that any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.



*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HelloWorld {

    private static Integer answer = 1000000;


    public static  void  recurse(List<Integer> arrList, int index, int painterId, int totalPainter, int totalTimeTakenByCurrPainter, Integer ans, HashMap<Integer, Integer> timePainterMap) {
        if (index == arrList.size()) {
            timePainterMap.put(painterId, totalTimeTakenByCurrPainter);
            int maxValue = -1;
            for (Map.Entry<Integer, Integer> entry: timePainterMap.entrySet()) {
                maxValue = Math.max(entry.getValue(), maxValue);
            }
            answer = Math.min(answer, maxValue);
            return;
        }
        if (painterId > totalPainter) {
            return;
        }
        recurse(arrList, index+1, painterId, totalPainter, totalTimeTakenByCurrPainter + arrList.get(index), ans, timePainterMap);
        timePainterMap.put(painterId, totalTimeTakenByCurrPainter);
        recurse(arrList, index, painterId+1, totalPainter, 0, ans, timePainterMap);

    }
    public static void main2(String[] args) {
        String str = "abba";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        Integer ans = 0;
        for (Map.Entry<Character, Integer> entry: hashMap.entrySet()) {
            int tempAns = (entry.getValue() * (entry.getValue()-1))/2;
            ans+=tempAns;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        arrList.add(5);arrList.add(10);arrList.add(30);arrList.add(20);arrList.add(15);
        Integer ans = 1000000;
        HashMap<Integer, Integer> timePainterMap = new HashMap<>();
        int k = 3;
        recurse(arrList, 0, 1, k, 0, ans, timePainterMap);
        System.out.println(answer);
    }







}