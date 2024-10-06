package org.example;

import java.util.Objects;
import java.util.TreeSet;

public class UsageOfTreeSet {

    public static void main(String[] args) {
        System.out.println("Hello");
        TreeSet<AnotherClass> treeSet = new TreeSet<>();
        AnotherClass firstInstance = new AnotherClass(10, "Mithoon");
        AnotherClass secondInstance = new AnotherClass(20, "Second");
        AnotherClass thirdInstance = new AnotherClass(5, "Third");
        treeSet.add(firstInstance);
        treeSet.add(secondInstance);
        treeSet.add(thirdInstance);
        System.out.println(treeSet);

        System.out.println(treeSet.getFirst());
        System.out.println(treeSet.getLast());

        System.out.println(treeSet.headSet(thirdInstance));

    }
}

class AnotherClass implements Comparable<AnotherClass>{
    private Integer age;
    private String name;

    public AnotherClass(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(AnotherClass o) {
        if (Objects.equals(this.age, o.getAge())) {
            return 0;
        }
        return this.age > o.getAge() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "AnotherClass{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}
