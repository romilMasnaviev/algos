package ru.masnaviev.arraysAndHashing.yandexAlgo.secondSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketSequence {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        ////////////////////////////////////////////////////////

        String str = reader.readLine();

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        outputBuilder.append(isBracketSequence_improve(str));

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

    public static String isBracketSequence(String str) {
        char[] arr = str.toCharArray();

        if (arr.length == 0) {
            return "True";
        }

        Stack<Character> stack = new Stack<>();

        for (char chr : arr) {
            if (stack.isEmpty() || chr == '{' || chr == '[' || chr == '(') {
                stack.push(chr);
            } else {
                if (chr == '}') {
                    if (stack.peek() == '{') stack.pop();
                } else if (chr == ']') {
                    if (stack.peek() == '[') stack.pop();
                } else if (chr == ')') {
                    if (stack.peek() == '(') stack.pop();
                } else {
                    stack.push(chr);
                }
            }
        }
        return stack.isEmpty() ? "True" : "False";
    }


    public static String isBracketSequence_improve(String str) {
        char[] arr = str.toCharArray();
        if (arr.length == 0) {
            return "True";
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        for (char chr : arr) {
            if (map.containsValue(chr)) {
                stack.push(chr);
            } else if (map.containsKey(chr)) {
                if (!stack.isEmpty() && stack.peek() == map.get(chr)) {
                    stack.pop();
                } else {
                    return "False";
                }
            }
        }
        return stack.isEmpty() ? "True" : "False";
    }
}
