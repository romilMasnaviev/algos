package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

public class MyNode {

    private final int value;
    private MyNode prev;
    private MyNode next;

    public MyNode getPrev() {
        return prev;
    }

    public MyNode(int value) {
        this.value = value;
    }

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                '}';
    }
}
