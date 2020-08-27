package com.ly.oj;

import java.util.Stack;

public class No_20_isValid {


    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                char in = 0;
                if (stack.size() > 0) {
                    in = stack.pop();
                }
                if ((in == '(' && c == ')') || (in == '{' && c == '}') || (in == '[' && c == ']')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

} 
