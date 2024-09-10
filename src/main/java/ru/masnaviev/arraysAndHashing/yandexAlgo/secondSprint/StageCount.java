package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StageCount {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);

        int num = Integer.parseInt(tokenizer.nextToken());
        int num2 = Integer.parseInt(tokenizer.nextToken());


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        outputBuilder.append(findFNums((recurse(num)), num2));

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

    public static int recurse(int a) {
        if (a < 2) {
            return 1;
        }
        a--;
        return recurse(a) + recurse(--a);
    }

    // 1 1 2 3 5 8
    public static String findFNums(int a, int k) {
        StringBuilder sb = new StringBuilder();
        while (k != 0 && a != 0) {
            sb.append(a % 10);
            a /= 10;
            k--;
        }
        return sb.toString();
    }


}
