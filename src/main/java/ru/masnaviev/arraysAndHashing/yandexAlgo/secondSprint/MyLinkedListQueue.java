package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedListQueue {
    private final List<Integer> list;

    public MyLinkedListQueue() {
        this.list = new LinkedList<>();
    }

    public Integer get() {
        if (list.isEmpty()) {
            System.out.println("error");
        } else {
            int x = list.get(0);
            list.remove(0);
            return x;
        }
        return null;
    }

    public Integer put(int x) {
        list.add(x);
        return list.get(list.size() - 1);
    }

    public Integer size(){
        return list.size();
    }


}
