package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Mom {
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        Node<String> node10 = new Node<>("Node 9", null);
        Node<String> node9 = new Node<>("Node 8", node10);
        Node<String> node8 = new Node<>("Node 7", node9);
        Node<String> node7 = new Node<>("Node 6", node8);
        Node<String> node6 = new Node<>("Node 5", node7);
        Node<String> node5 = new Node<>("Node 4", node6);
        Node<String> node4 = new Node<>("Node 3", node5);
        Node<String> node3 = new Node<>("Node 2", node4);
        Node<String> node2 = new Node<>("Node 1", node3);
        Node<String> node1 = new Node<>("Node 0", node2);


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        outputBuilder.append(findByValue(node1,"Node 5"));

        //TODO

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


    public static <V> int findByValue(Node<V> head, V value) {
        Node<V> current = head;
        int i = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }
}
