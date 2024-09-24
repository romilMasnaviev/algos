package ru.masnaviev.arraysAndHashing.yandexAlgo.thirdSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Combinations {

    public static HashMap<Integer, List<Character>> lettersOnKeyMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        // Подготовка чтения и вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputBuilder = "";
        ////////////////////////////////////////////////////////

        String str = reader.readLine();

        char[] charArr = str.toCharArray();
        int[] arr = new int[charArr.length];

        for (int i = 0; i < charArr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(charArr[i]));
        }
        System.out.println(arr.length);

        ////////////////////////////////////////////////////////
        // Измерение времени
        long startTime = System.nanoTime();

        // Измерение памяти
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //TODO

        lettersOnKeyMap.put(2, List.of('a', 'b', 'c'));
        lettersOnKeyMap.put(3, List.of('d', 'e', 'f'));
        lettersOnKeyMap.put(4, List.of('g', 'h', 'i'));
        lettersOnKeyMap.put(5, List.of('j', 'k', 'l'));
        lettersOnKeyMap.put(6, List.of('m', 'n', 'o'));
        lettersOnKeyMap.put(7, List.of('p', 'q', 'r', 's'));
        lettersOnKeyMap.put(8, List.of('t', 'u', 'v'));
        lettersOnKeyMap.put(9, List.of('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        combinationsCalculate(arr,"", 0,result);

        System.out.println(result);

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


    public static void combinationsCalculate(int[] arr, String word, int currentIndex, List<String> result) {
        if (currentIndex == arr.length) {
            result.add(word);
        } else {
            for (int i = 0; i < lettersOnKeyMap.get(arr[currentIndex]).size(); i++) {
                combinationsCalculate(arr,word + lettersOnKeyMap.get(arr[currentIndex]).get(i), currentIndex+1,result);
            }
        }
    }
}
