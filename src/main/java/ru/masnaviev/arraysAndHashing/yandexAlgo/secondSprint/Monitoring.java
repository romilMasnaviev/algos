package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Monitoring {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        int rows = Integer.parseInt(reader.readLine()); // строка
        int cols = Integer.parseInt(reader.readLine()); // столбец

        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String str = reader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(str);
            for (int j = 0; j < cols; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        outputBuilder.append(monitoring(arr));

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

    public static String monitoring(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        int cols = arr[0].length; // строка
        int rows = arr.length; // столбец

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                sb.append(arr[j][i]);
                if (j < rows - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
