package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subsequence {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringBuilder = "";
        ////////////////////////////////////////////////////////

        String subLine = reader.readLine();
        String line = reader.readLine();

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        System.out.println(isSubsequence(subLine, line));

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
        System.out.println("Результат :" + stringBuilder);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }


    public static String isSubsequence(String subLine, String line) {
        char[] subLineArr = subLine.toCharArray();
        char[] lineArr = line.toCharArray();

        if (subLineArr.length > lineArr.length || lineArr.length == 0) {
            return "False";
        }
        for (int i = 0; i < lineArr.length; i++) {
            if (lineArr[i] == subLineArr[0]) {
                int subLineIndex = 1;
                for (int j = i + 1; j < lineArr.length && subLineIndex != subLineArr.length; j++) {
                    if (lineArr[j] == subLineArr[subLineIndex]) {
                        subLineIndex++;
                    }
                }
                if (subLineIndex == subLineArr.length) {
                    return "True";
                }
            }
        }
        return "False";
    }

}
