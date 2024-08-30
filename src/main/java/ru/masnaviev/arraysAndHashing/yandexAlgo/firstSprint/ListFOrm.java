package ru.masnaviev.arraysAndHashing.yandexAlgo.firstSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListFOrm {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        int size = Integer.parseInt(reader.readLine());

        int[] arr = new int[size];

        String secondLine = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(secondLine);
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            i++;
        }

        int k = Integer.parseInt(reader.readLine());

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        outputBuilder.append(listForm(arr, k));

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

    public static String listForm(int[] arr, int k) {
        int sum = 0;
        int mult = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i] * mult;
            mult *= 10;
        }
        sum += k;

        StringBuilder sb = new StringBuilder();
        while (sum > 10) {
            sb.append(sum % 10).append(" ");
            sum /= 10;
        }
        sb.append(sum);
        return sb.reverse().toString();
    }


}
