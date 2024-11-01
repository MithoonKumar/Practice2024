package org.testing;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(-7%3 + 3);
        System.out.println("sds");
        canArrange(new int[]{-1, 1,-2, 2, -3,3,-4,4}, 3);
    }

    public static boolean canArrange(int[] arr, int k) {
        int newArr[] = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            newArr[i] = (arr[i] %k);
            System.out.println(newArr[i]);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<newArr.length; i++) {
            hashMap.put(newArr[i], hashMap.getOrDefault(newArr[i], 0) + 1);
        }

        if (k%2 == 0 &&  hashMap.get(k/2)!=null && hashMap.get(k/2)%2 == 1) {
            System.out.println("first case");
            return false;
        }
        hashMap.put(0, hashMap.getOrDefault(0, 0));
        if (hashMap.get(0) %2 ==1) {
            System.out.println("second case");
            return false;
        }
        for (int i=1; i<=k/2; i++) {
            int first = i;
            int second = k-i;
            if (hashMap.get(first) != hashMap.get(second)) {
                System.out.println(hashMap.get(first));
                System.out.println(hashMap.get(second));
                System.out.println("third case");
                return false;
            }
        }
        return true;

    }
}
