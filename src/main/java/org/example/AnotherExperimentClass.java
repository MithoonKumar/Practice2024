package org.example;


import java.util.*;

public class AnotherExperimentClass {

    public static void main(String[] args) {
        System.out.println(longestDiverseString(7, 1, 0));
    }


    public static int findLargestChar(int [] arr) {
        int index = -1;
        int val = 0;
        for (int i=0; i<arr.length; i++) {
            if (val < arr[i]) {
                val = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int findNextGreaterChar(int[] arr, int index) {
        int val = 0;
        int newIndex = -1;

        for (int i=0; i<arr.length; i++) {
            if (i == index) {
                continue;
            }
            if (arr[i] > val) {
                newIndex = i;
                val = arr[i];
            }
        }
        return newIndex;
    }

    public static String longestDiverseString(int a, int b, int c) {
        int[] arr = {a, b, c};

        StringBuilder sb = new StringBuilder("");
        while(true) {
            int largestChar = findLargestChar(arr);
            if (largestChar == -1) {
                return sb.toString();
            } else {
                int len = sb.length();
                if ( len >= 2) {
                    if (sb.charAt(len-1)-'a' == largestChar && sb.charAt(len-2)-'a' == largestChar) {
                        int nextChar = findNextGreaterChar(arr, largestChar);
                        if (nextChar == -1) {
                            return sb.toString();
                        } else {
                            sb.append('a' + nextChar);
                            arr[nextChar]--;
                        }
                    }
                } else {
                    sb.append('a' + largestChar);
                    arr[largestChar]--;
                }
            }


        }
    }


}