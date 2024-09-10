package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputBuilder = "";
        ////////////////////////////////////////////////////////

        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);


        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        calculate(line);

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

    public static int calculate(String str) {
        StringTokenizer st = new StringTokenizer(str);
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> signs = new Stack<>();
        HashSet<String> baseSigns = new HashSet<>();
        baseSigns.add("+");
        baseSigns.add("-");
        baseSigns.add("*");
        baseSigns.add("/");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (baseSigns.contains(token)) {
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                numbers.push(execute(token, num2, num1));
            } else {
                numbers.push(Integer.parseInt(token));
            }
            System.out.println("signs = " + signs);
            System.out.println("numbers = " + numbers);
        }

        return 0;


    }

    private static int execute(String str, int first, int second) {
        switch (str) {
            case ("+"):
                return first + second;
            case ("-"):
                return first - second;
            case ("/"):
                return first / second;
            default:
                return first * second;
        }
    }
}
