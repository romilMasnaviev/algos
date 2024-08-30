package ru.masnaviev.arraysAndHashing;

import java.util.Arrays;
import java.util.Stack;

public class test {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        String str0 = "str 0";
        String str1 = "str 1";
        String str2 = "str 2";
        String str3 = "str 3";
        String str4 = "str 4";
        String str5 = "str 5";

        stack.push(str0);
        stack.push(str1);
        stack.push(str2);
        stack.push(str3);
        stack.push(str4);
        stack.push(str5);

        System.out.println("stack = " + stack);
        stack.pop();
        System.out.println("stack = " + stack);
        stack.peek();
        System.out.println("stack = " + stack);
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        System.out.println("stack.empty() = " + stack.empty());
    }
}
