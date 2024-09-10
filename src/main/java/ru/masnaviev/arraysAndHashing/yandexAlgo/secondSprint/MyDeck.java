package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

public class MyDeck {
    private final int size;
    int currentSize;
    private MyNode head;
    private MyNode tail;

    public MyDeck(int size) {
        this.size = size;
        head = null;
        tail = null;
        currentSize = 0;
    }

    public MyNode pushBack(MyNode node) { // добавить в конец списка
        if (size == currentSize) {
            System.out.println("error");
            return null;
        }
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        currentSize++;
        return node;
    }

    public MyNode popFront() { //вывести первый элемент дека и удалить его.
        if (currentSize == 0) {
            System.out.println("error");
            return null;
        }
        MyNode node = head;
        if (currentSize == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        currentSize--;
        return node;
    }

    public MyNode pushFront(MyNode node) {  // добавить в начало списка
        if (size == currentSize) {
            System.out.println("error");
            return null;
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.setPrev(node);
            node.setNext(head);
        }
        currentSize++;
        head = node;
        return node;
    }

    public MyNode popBack() { // вывести последний элемент дека и удалить его
        if (currentSize == 0) {
            System.out.println("error");
            return null;
        }
        MyNode node = tail;
        if (currentSize == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        currentSize--;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        MyNode node = head;
        while (node != null) {
            stringBuilder.append(node).append(" ");
            node = node.getNext();
        }
        return "MyDeck{} = " + stringBuilder;
    }
}
