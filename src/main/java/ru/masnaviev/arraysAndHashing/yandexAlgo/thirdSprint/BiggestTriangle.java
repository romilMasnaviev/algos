package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BiggestTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Integer[] sides = new Integer[parseInt(reader.readLine())];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int i = 0;
        while (tokenizer.hasMoreElements()) {
            sides[i++] = Integer.parseInt(tokenizer.nextToken());
        }


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        sb.append(calc_biggest_perimeter(sides));
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

    public static int calc_biggest_perimeter(Integer[] sides) {
        Arrays.sort(sides, Collections.reverseOrder());

        for (int i = 0; i < sides.length - 2; i++) {
            if (sides[i] < sides[i + 1] + sides[i + 2]) {
                return sides[i] + sides[i + 1] + sides[i + 2];
            }
        }
        return 0;
    }
}
