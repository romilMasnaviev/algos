package ru.masnaviev.arraysAndHashing.yandexAlgo.firstSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.pow;

public class BinarySum {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        char[] first = reader.readLine().toCharArray();
        char[] second = reader.readLine().toCharArray();

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        outputBuilder.append(binarySum(first,second));

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
        System.out.println("Результат = " + outputBuilder);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }


    public static int fromBinary(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int) (arr[i] * pow(2, arr.length - 1 - i));
        }
        return sum;
    }

    public static String binarySum(char[] first, char[] second) {
        int[] firstIntArr = new int[first.length];
        int[] secondIntArr = new int[second.length];

        for (int i = 0; i < first.length; i++) {
            firstIntArr[i] = first[i] - '0';
        }

        for (int i = 0; i < second.length; i++) {
            secondIntArr[i] = second[i] - '0';
        }

        int firstInt = fromBinary(firstIntArr);
        int secondInt = fromBinary(secondIntArr);

        return recursBinary(firstInt + secondInt);
    }

    public static String recursBinary(int rest) {
        if (rest <= 0) {
            return "";
        }
        return recursBinary(rest / 2) + (rest % 2);
    }

}
