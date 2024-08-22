package ru.masnaviev.arraysAndHashing.yandexAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//A man, a plan, a canal: Panama
public class Palindrome {

    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////

        String text = reader.readLine();
        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        output.append(isPalindrome(text));

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
        System.out.println("Результат = \n" + output);
        System.out.printf("Время выполнения: %.6f секунд%n", durationSeconds);
        System.out.printf("Используемая память: %.6f байт%n", memoryUsedMB);
    }

    public static String isPalindrome(String text) {
        String textWithout = text.replaceAll("(?U)[\\pP\\s]","");
        char[] str = textWithout.toLowerCase().toCharArray();
        int length = str.length;
        for (int i = 0; i < text.length() / 2; i++) {
            if (str[i] != str[length - 1 - i]) {
                return "False";
            }
        }
        return "True";
    }
}
