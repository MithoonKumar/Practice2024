package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        List<String> firstList = Arrays.stream(sentence1.split(" ")).toList();
        List<String> secondList = Arrays.stream(sentence2.split(" ")).toList();
        boolean res1, res2, res3, res4, res5, res6;
        res1 = leftHalfFirstSmallMatching(firstList, secondList);
        res2 = rightHalfFirstSmallMatching(firstList, secondList);
        res3 = secondSmallMatching(firstList, secondList);
        return res1 || res2 || res3;
    }

    public boolean leftHalfFirstSmallMatching(List<String> firstList, List<String> secondList) {
        int p1 = 0, p2 = 0;
        while (p1<firstList.size() && p2 < secondList.size()) {
            if (!Objects.equals(firstList.get(p1++), secondList.get(p2++))) {
                return false;
            }
        }
        return true;
    }



    public boolean rightHalfFirstSmallMatching(List<String> firstList, List<String> secondList) {
        int p1 = firstList.size()-1, p2 = secondList.size()-1;
        while (p1>=0 && p2 >=0) {
            if (!Objects.equals(firstList.get(p1--), secondList.get(p2--))) {
                return false;
            }
        }
        return true;
    }

    public boolean secondSmallMatching(List<String> firstList, List<String> secondList) {
        int p1 = 0, p2 = 0, p3 = firstList.size()-1, p4 = secondList.size()-1;
        while (p1 < p3 && p2 < p4) {
            if (p1 == p3 || p2 == p4) {
                if (!Objects.equals(firstList.get(p1++), secondList.get(p2++)) && !Objects.equals(firstList.get(p3--), secondList.get(p4--))) {
                    return false;
                }
            } else {
                if (!Objects.equals(firstList.get(p1++), secondList.get(p2++))) {
                    return false;
                }
                if (!Objects.equals(firstList.get(p3--), secondList.get(p4--))) {
                    return false;
                }
            }
        }
        return true;
    }


}
