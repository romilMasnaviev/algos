package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringBuilder = "";
        ////////////////////////////////////////////////////////


        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        merge_sort(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));

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


    public static int[] merge(int[] arr, int left, int mid, int right) {

        int[] first = new int[mid - left];
        int[] second = new int[right - mid];

        if (mid - left >= 0) System.arraycopy(arr, 0, first, 0, mid - left);
        if (right - mid >= 0) System.arraycopy(arr, mid, second, 0, right - mid);

        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;

        while (firstIndex < first.length && secondIndex < second.length) {
            arr[resultIndex++] = first[firstIndex] < second[secondIndex] ? first[firstIndex++] : second[secondIndex++];
        }
        while (resultIndex < first.length + second.length) {
            arr[resultIndex++] = firstIndex != first.length ? first[firstIndex++] : second[secondIndex++];
        }

        return arr;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (right - left > 1) {
            int mid = (left + right) / 2;
            if ((left + right) % 2 != 0) {
                mid++;
            }
            merge_sort(arr, 0, mid);
            merge_sort(arr, mid, right);
            merge(arr, 0, mid, right);
        }
    }


}
