package org.designPatterns;

import java.util.HashMap;
import java.util.HashSet;

public class SingletonDesignPattern {

    public static void main(String[] args) {
        System.out.println("Hello world");
        SingletonClass singletonClass1 = SingletonClass.getSingletonClassInstance();
        SingletonClass singletonClass2 = SingletonClass.getSingletonClassInstance();

        System.out.println(singletonClass1);
        System.out.println(singletonClass2);

    }

}


class SingletonClass {

    private static SingletonClass singletonClassInstance;

    private SingletonClass() {
    }

    public static SingletonClass getSingletonClassInstance() {
        if (singletonClassInstance == null) {
            singletonClassInstance = new SingletonClass();
        }
        return singletonClassInstance;
    }
}
