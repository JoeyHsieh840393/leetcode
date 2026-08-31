package com.example;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (c == ')' && !stack.pop().equals('(')) {
                    return false;
                }

                if (c == ']' && !stack.pop().equals('[')) {
                    return false;
                }
                if (c == '}' && !stack.pop().equals('{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}