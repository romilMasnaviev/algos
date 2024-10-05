package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Cookies {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int[] children_greed = new int[parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < children_greed.length; i++) {
            children_greed[i] = parseInt(tokenizer.nextToken());
        }

        int[] cookies_size = new int[parseInt(reader.readLine())];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < cookies_size.length; i++) {
            cookies_size[i] = parseInt(tokenizer.nextToken());
        }


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        sb.append(calc_funny(children_greed, cookies_size));
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
        System.out.println("Результат :" + sb);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);

    }

    public static int calc_funny(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int childIndex = 0;
        int cookieIndex = 0;

        while (childIndex != children.length && cookieIndex != cookies.length) {
            if (children[childIndex] > cookies[cookieIndex]) {
                return childIndex;
            } else {
                childIndex++;
                cookieIndex++;
            }
        }
        return childIndex;
    }
}
