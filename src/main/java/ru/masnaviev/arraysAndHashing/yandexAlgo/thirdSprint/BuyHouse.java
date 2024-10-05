package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BuyHouse {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = parseInt(tokenizer.nextToken());
        int money = parseInt(tokenizer.nextToken());

        int[] houses_prices = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < houses_prices.length; i++) {
            houses_prices[i] = parseInt(tokenizer.nextToken());
        }


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        sb.append(calc_houses(money, houses_prices));
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

    public static int calc_houses(int money, int[] houses_prices) {

        Arrays.sort(houses_prices);

        int index = 0;

        while ( index!=houses_prices.length){
            if(money - houses_prices[index] > 0){
                money -= houses_prices[index];
                index++;
            } else {
                return index;
            }
        }
        return index;
    }
}
