package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//6
//1 2 4 4 6 8
//3
public class TwoBicycles {
    //Ваша задача — по заданной стоимости велосипеда определить
    //• первый день, в которой Вася смог бы купить один велосипед,
    //• и первый день, в который Вася смог бы купить два велосипеда.
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        int num = Integer.parseInt(reader.readLine());
        int[] arr = new int[num];

        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);


        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int cost = Integer.parseInt(reader.readLine());


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO


        outputBuilder.append(twoByc(arr, cost));

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

    public static String twoByc(int[] arr, int cost) {
        String stringBuilder = binary(arr, cost, 0, arr.length + 1) + " " +
                binary(arr, cost * 2, 0, arr.length + 1);
        return stringBuilder;
    }

    public static int binary(int[] arr, int x, int left, int right) {
        if (arr[arr.length - 1] < x) {
            return -1;
        }
        int center = (left + right) / 2;
        if (left == right) {
            return center + 1;
        }
        if (arr[center] > x) {
            return binary(arr, x, left, center);
        } else if (arr[center] < x) {
            return binary(arr, x, center + 1, right);
        } else {
            return center + 1;
        }
    }


}
