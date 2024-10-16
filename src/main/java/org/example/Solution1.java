package org.example;


import java.util.Stack;

class Solution1 {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            Character currChar = s.charAt(i);
            if (stack.size() == 0) {
                stack.add(currChar);
            } else {
                Character top = stack.peek();
                if (top == 'A' && currChar == 'B') {
                    stack.pop();
                    continue;
                }
                if (top == 'C' && currChar == 'D') {
                    stack.pop();
                    continue;
                }
                stack.add(currChar);
            }
        }
        return stack.size();
    }
}