package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

public class MaxStack {
    private final int[] arr;
    private int i = 0;

    public MaxStack() {
        arr = new int[10000];
    }

    public void push(int number) {
        arr[i++] = number;
    }

    public void pop() {
        if (i == 0) {
            System.out.println("error");
            return;
        }
        arr[i--] = 0;
    }

    public void get_max() {
        if (i == 0) {
            System.out.println("None");
            return;
        }
        int max = arr[0];
        for (int j = 0; j < i; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        System.out.println(max);
    }


}
