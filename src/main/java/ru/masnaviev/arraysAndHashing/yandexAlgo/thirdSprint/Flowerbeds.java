package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Flowerbeds {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringBuilder = "";
        ////////////////////////////////////////////////////////

        int n = Integer.parseInt(reader.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        sortFlowerbeds(arr);

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        calculateFlowerbeds(sortFlowerbeds(arr));
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


    // [0] - начало отрезка
    // [1] - конец отрезка
    public static void calculateFlowerbeds(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i][1] >= arr[i + 1][0]) {
                arr[i + 1][0] = arr[i][0];
                arr[i + 1][1] = max(arr[i][1], arr[i + 1][1]);
                arr[i] = null;
            }
        }

    }

    public static int[][] sortFlowerbeds(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    int[] tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                } else if (arr[j][0] == arr[j + 1][0]) {
                    if (arr[j][1] > arr[j + 1][1]) {
                        int[] tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
        }
        return arr;
    }


}
