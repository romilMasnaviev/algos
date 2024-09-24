package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BracketGenerator {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputBuilder = "";
        ////////////////////////////////////////////////////////

        int n = Integer.parseInt(reader.readLine());


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        String str = new String();
        generate(n, n, str, list);

        System.out.println(list);
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

    public static void generate(int open, int close, String str, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(str);
            return;
        }
        if (open > 0) {
            generate(open - 1, close, str + "(", result);
        }
        if (close > open) {
            generate(open, close - 1, str + ")", result);
        }
    }
}
