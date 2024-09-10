package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Deck {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        MyDeck deck = new MyDeck(10);

        MyNode node = new MyNode(0);
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        deck.pushBack(node);
        deck.pushBack(node1);
        deck.pushBack(node2);

        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);
        deck.pushFront(node3);
        deck.pushFront(node4);
        deck.pushFront(node5);

        System.out.println(deck);

        deck.popBack();
        deck.popBack();
        deck.popBack();

        deck.popFront();
        deck.popFront();
        deck.popFront();

        System.out.println(deck);

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
}
