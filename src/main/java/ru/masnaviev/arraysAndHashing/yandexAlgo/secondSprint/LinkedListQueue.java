package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListQueue {
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        String str = reader.readLine();

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO
//        MyQueueSized myQueue = new MyQueueSized(2);
//        myQueue.peek();
//        myQueue.push(5);
//        myQueue.push(2);
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.size());
//        System.out.println(myQueue.size());
//        myQueue.push(1);
//        System.out.println(myQueue.size());

        MyLinkedListQueue myQueue = new MyLinkedListQueue();
        myQueue.put(-34);
        myQueue.put(-23);
        System.out.println(myQueue.get());
        System.out.println(myQueue.size());
        System.out.println(myQueue.get());
        System.out.println(myQueue.size());
        System.out.println(myQueue.get());
        System.out.println(myQueue.get());
        myQueue.put(80);
        System.out.println(myQueue.size());


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
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }

}
