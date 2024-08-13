package ru.masnaviev.arraysAndHashing.yandexAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenAndOddNums {
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        StringBuilder outputBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        ////////////////////////////////////////////////////////

        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        String result = play2(a, b, c);

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


    //версия 1
    public static String play(int a, int b, int c) {
        if (a % 2 == 0) {
            if (b % 2 == 0) if (c % 2 == 0) return "WIN";
        } else if (b % 2 != 0) if (c % 2 != 0) return "WIN";
        return "FAIL";
    }

    //версия 2
    //лучше по читаемости, по производительности они одинаковые
    public static String play2(int a, int b, int c) {
        if(isEven(a) == isEven(b) == isEven(c)) return "WIN";
        return "FAIL";
    }

    private static boolean isEven(int a) {
        return a % 2 == 0;
    }


}