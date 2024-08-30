package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.util.Stack;

public class MaxStackEffective {
    private final Stack<Integer> stack;
    private final Stack<Integer> maxStack;

    public MaxStackEffective() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int element) {
        stack.push(element);

        if (maxStack.isEmpty() || maxStack.peek() <= element) {
            maxStack.push(element);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("error");
            return;
        }
        int num = stack.pop();
        if (maxStack.peek() == num) {
            maxStack.pop();
        }
    }

    public void get_max() {
        if (maxStack.isEmpty()) {
            System.out.println("None");
            return;
        }
        System.out.println(maxStack.peek());
    }


}

