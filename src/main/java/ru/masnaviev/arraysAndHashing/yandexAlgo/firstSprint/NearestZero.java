package ru.masnaviev.arraysAndHashing.yandexAlgo.firstSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NearestZero {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        int num = Integer.parseInt(reader.readLine());

        String str = reader.readLine();

        int[] arr = new int[num];

        StringTokenizer tokenizer = new StringTokenizer(str);
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        outputBuilder.append(Arrays.toString(nearestZero(arr)));

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


    public static int[] nearestZero(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int k = i;
            while (k > 0) {
                if (arr[k] == 0) {
                    break;
                }
                k--;
            }
            newArr[i] = i - k;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int k = i;
            int flag = 0;
            while (k < arr.length) {
                if (arr[k] == 0) {
                    flag = 1;
                    break;
                }
                k++;
            }
            if (newArr[i] > (k - i) && flag == 1) {
                newArr[i] = k - i;
            }
        }

        return newArr;
    }


}
