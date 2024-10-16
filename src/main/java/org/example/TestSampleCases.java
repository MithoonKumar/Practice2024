package org.example;

import java.util.ArrayList;
import java.util.List;

public class TestSampleCases {

    public static void main(String[] args) {
        int k = 10;
        Integer first = 10;
        int [] arr = {1, 2 ,3};
        Integer [] Arr = {1, 2, 3};
        SomeClass someClass = new SomeClass(10);
        test(k, first, arr, Arr, someClass);
        System.out.println(k);
        System.out.println(first);
        System.out.println(arr[1]);
        System.out.println(Arr[1]);
        System.out.println(someClass.k);
        List<String> kk =  new ArrayList<>();
        List<String> aa = new ArrayList<>();
        kk.add("first");
        aa.add("new");
        aa.addAll(kk);
        System.out.println(aa);


    }

    public static void test(int k, Integer first, int []arr, Integer [] Arr, SomeClass someClass) {
        k = 12;
        first = 12;
        arr[1] =12;
        Arr[1] = 12;
        someClass.k = 12;
    }
}


class SomeClass {
    public int k;

    public SomeClass(int k) {
        this.k = k;
    }


}