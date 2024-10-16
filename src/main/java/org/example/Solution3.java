package org.example;

import java.util.*;

class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Element> hashSet = new HashSet<>();
        HashMap<Integer, TreeSet<Integer>> hashMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            TreeSet<Integer> treeSet = hashMap.getOrDefault(nums[i], new TreeSet<>());
            treeSet.add(i);
            hashMap.put(nums[i], treeSet);
        }
        int len = nums.length;
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                int currSum = nums[i] + nums[j];
                TreeSet<Integer> currTreeSet = hashMap.get(0-currSum);
                if (currTreeSet.tailSet(j+1).size()>0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[currTreeSet.tailSet(j+1).first()]);
                    Collections.sort(list);
                    hashSet.add(new Element(list.get(0), list.get(1), list.get(2)));
                }
            }
        }
        for (Element e: hashSet) {
            List<Integer> list = new ArrayList<>();
            list.add(e.first);
            list.add(e.second);
            list.add(e.third);
            ans.add(list);
        }
        return ans;

    }

}

class Element {
    int first, second, third;

    public Element(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public boolean equals(Object obj) {
        Element e = (Element) obj;
        return this.first == e.first && this.second == e.second && this.third == e.third;
    }


}