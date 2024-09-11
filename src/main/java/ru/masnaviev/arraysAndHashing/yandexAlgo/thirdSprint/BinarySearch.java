package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputBuilder = "";
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

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 3;
        int left = 0;
        int right = 10;

        System.out.println(binary(arr,x,left,right));
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

    public static int binary(int[] arr, int x, int left, int right) {
        int center = (left + right) / 2;
        if (left == right) {
            return -1;
        }
        if (arr[center] > x) {
            return binary(arr, x, left, center);
        } else if (arr[center] < x) {
            return binary(arr, x, center+1, right);
        } else {
            return center;
        }
    }


}
