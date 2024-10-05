package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wardrobe {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] arr = new int[n];
        int i = 0;
        while (tokenizer.hasMoreElements()) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        sb.append(Arrays.toString(calc_wardrobe(arr)));
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

    public static int[] calc_wardrobe(int[] arr) {
        int[] colour_arr = new int[3];
        int[] result = new int[arr.length];
        for (int j : arr) {
            colour_arr[j]++;
        }

        int k = 0;
        for (int j = 0; j < colour_arr.length; j++) {
            for (int i = 0; i < colour_arr[j]; i++) {
                result[k++] = j;
            }
        }
        return result;
    }
}
