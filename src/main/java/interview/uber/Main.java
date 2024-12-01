package interview.uber;

import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(7);
        treeSet.add(11);
        treeSet.add(13);
        treeSet.add(17);
        treeSet.add(19);
        System.out.println(treeSet.higher(17));
    }


}
