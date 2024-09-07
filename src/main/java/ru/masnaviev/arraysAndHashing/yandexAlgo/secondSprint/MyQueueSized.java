package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

public class MyQueueSized {
    private final int[] arr;
    private final int maxN;
    private  int size;
    private int head;
    private int tail;

    public MyQueueSized(int maxN) {
        arr = new int[maxN];
        head = 0;
        tail = 0;
        size = 0;
        this.maxN = maxN;
    }

    public Integer push(int element) {
        if (size == maxN) {
            System.out.println("error");
        } else {
            arr[tail] = element;
            tail = (tail + 1) % maxN;
            size++;
        }
        return element;
    }

    public Integer pop() {
        if (size == 0) {
            System.out.println("None");
        } else {
            int x = arr[head];
            arr[head] = 0;
            head = (head + 1) % maxN;
            size--;
            return x;
        }
        return null;
    }

    public Integer peek(){
        if(size == 0){
            System.out.println("None");
        } else {
            return arr[head];
        }
        return null;
    }

    public int size(){
        return size;
    }

}
