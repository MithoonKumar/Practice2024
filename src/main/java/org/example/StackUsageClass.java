package org.example;

import java.util.Stack;

public class StackUsageClass {

    public static void main(String[] args) {
        System.out.println("Hello");
        Stack<Character> characterStack = new Stack<>();
        characterStack.add('H');
        characterStack.add('M');
        characterStack.add('K');
        System.out.println(characterStack.peek());
        characterStack.pop();
        System.out.println(characterStack.peek());
    }
}
