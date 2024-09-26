package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargestNumber {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputBuilder = "";
        ////////////////////////////////////////////////////////

        int n = Integer.parseInt(reader.readLine());

        String[] arr = new String[n];

        String str = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(str);
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            arr[i] = tokenizer.nextToken();
            i++;
        }

        bubbleSort(arr);

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO


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


    public static boolean isBetterNumber(String num1, String num2) {
        String firstNum = num1 + num2;
        String secondNum = num2 + num1;


        return firstNum.compareTo(secondNum) < 0;
    }

    public static void bubbleSort(String[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (isBetterNumber(arr[j], arr[j + 1])) {
                    String tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

}
