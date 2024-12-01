package Salesforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxProfit {


    public static int recurse(int [] arr, int index, int currK, HashMap<String, Integer> hashMap) {
        String key = String.valueOf(index) + "_" + String.valueOf(currK);
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }

        if (currK == 0) {
            return 0;
        }

        if (index == arr.length) {
            return 0;
        }

        if (currK % 2 == 0) {
            int first = -arr[index] + recurse(arr, index+1, currK-1, hashMap);
            int second = recurse(arr, index+1, currK, hashMap);

            int ans =  Math.max(first, second);
            hashMap.put(key, ans);
            return ans;
        } else {
            int first = arr[index] + recurse(arr, index+1, currK-1, hashMap);
            int second = recurse(arr, index+1, currK, hashMap);
            int ans =  Math.max(first, second);
            hashMap.put(key, ans);
            return ans;
        }
    }


    public static void main(String[] args) {
        System.out.println("Hi");
        List<Integer> list = new ArrayList<>(2200);
        list.add(12);
        list.add( 12);

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
//
//        int [] arr = {10, 22, 14, 80, 85, 30, 56};
//
//        int k = 2;
//        k = k*2;
//
//        HashMap<String, Integer> hashMap = new HashMap<>();
//
//        int ans = recurse(arr, 0, k, hashMap);
//        System.out.println(ans);
    }
}
