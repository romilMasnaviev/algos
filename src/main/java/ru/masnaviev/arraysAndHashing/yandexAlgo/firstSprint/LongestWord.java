package ru.masnaviev.arraysAndHashing.yandexAlgo.firstSprint;
//19 i love segment tree

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestWord {
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////

        int L = Integer.parseInt(reader.readLine().trim());

        String text = reader.readLine();

        StringTokenizer tokenizer = new StringTokenizer(text, " ");

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        output.append(findLongestWord(tokenizer));

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
        System.out.println("Результат: \n" + output);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }

    public static String findLongestWord(StringTokenizer tokenizer) {
        String longestWord = "";
        int maxLength = 0;
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.length() > maxLength) {
                longestWord = word;
                maxLength = word.length();
            }
        }
        return longestWord + "\n" + maxLength;
    }
}
