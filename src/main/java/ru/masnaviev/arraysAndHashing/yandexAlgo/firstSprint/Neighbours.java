package ru.masnaviev.arraysAndHashing.yandexAlgo.firstSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//4 3 1 2 3 0 2 6 7 4 1 2 7 0 3 0
//4 3 1 2 3 0 2 6 7 4 1 2 7 0 0 0
public class Neighbours {
    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        StringBuilder outputBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        ////////////////////////////////////////////////////////

        int rows = Integer.parseInt(tokenizer.nextToken());
        int cols = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        System.out.println(Arrays.deepToString(arr));

        int y = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        int[] result = getNeighbours(arr, x, y, arr[0].length, arr.length);

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
        outputBuilder.append(Arrays.toString(result)).append("\n");
        System.out.println("Результат = " + outputBuilder);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }

    private static int[] getNeighbours(int[][] arr, int x, int y, int partLength, int fullLength) {
        List<Integer> list = new ArrayList<>(4);
        if (x > 0) list.add(arr[y][x-1]);
        if (x < partLength - 1) list.add(arr[y][x+1]);
        if (y > 0) list.add(arr[y-1][x]);
        if (y < fullLength - 1) list.add(arr[y+1][x]);
        return list.stream().sorted().mapToInt(o -> o).toArray();
    }


}