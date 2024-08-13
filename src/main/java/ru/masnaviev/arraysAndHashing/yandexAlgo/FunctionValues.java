package ru.masnaviev.arraysAndHashing.yandexAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FunctionValues {
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        StringBuilder outputBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        ////////////////////////////////////////////////////////

        int a = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        int result = calc(a, x, b, c);

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
        outputBuilder.append(result).append("\n");
        System.out.println("Результат = " + outputBuilder);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }


    //значение функции
    public static int calc(int a, int x, int b, int c) {
        return a * x * x + b * x + c;
    }

}