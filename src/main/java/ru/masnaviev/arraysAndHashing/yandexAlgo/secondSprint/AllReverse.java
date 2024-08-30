package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllReverse {
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputBuilder = "";
        ////////////////////////////////////////////////////////
        NewNode<String>[] nodes = new NewNode[10];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new NewNode<>("Node " + i, null, null);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
            }
            if (i < nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        //printAll(nodes[0]);
        printAll(reverse(nodes[0]));
        //TOD

        // Измерение памяти после выполнения кода
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;

        long endTime = System.nanoTime();
        long durationNano = endTime - startTime;

        // Преобразование в секунды и мегабайты
        double durationSeconds = durationNano / 1_000_000_000.0; // наносекунды в секунды
        double memoryUsedMB = memoryUsed;

        // Вывод результатов
        System.out.println("Результат :" + outputBuilder);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }

    public static <V> NewNode reverse(NewNode<V> head) {
        NewNode<V> newHead = null;

        while (head != null) {

            NewNode<V> temp = head.prev;

            head.prev = head.next;
            head.next = temp;

            newHead = head;

            head = head.prev;
        }

        return newHead;
    }

    public static <V> void printAll(NewNode<V> head) {
        NewNode<V> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

}

class NewNode<V> {
    public V value;
    public NewNode<V> next;
    public NewNode<V> prev;

    public NewNode(V value, NewNode<V> next, NewNode<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "NewNode{" +
                "value=" + value +
                '}';
    }
}