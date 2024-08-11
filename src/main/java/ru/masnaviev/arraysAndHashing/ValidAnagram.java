package ru.masnaviev.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

//Is Anagram
//        Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
//
//        An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
//
//        Example 1:
//
//        Input: s = "racecar", t = "carrace"
//
//        Output: true
//        Example 2:
//
//        Input: s = "jar", t = "jam"
//
//        Output: false
//        Constraints:
//
//        s and t consist of lowercase English letters.
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram_HashMap(s, t));
        System.out.println(isAnagram_Array(s, t));
        System.out.println(isAnagram_HashMap_V2(s, t));

    }

    public static boolean isAnagram_HashMap(String s, String t) {
        HashMap<Character, Integer> firstLetters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            firstLetters.put(s.charAt(i), firstLetters.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> secondLetters = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            secondLetters.put(t.charAt(i), secondLetters.getOrDefault(t.charAt(i), 0) + 1);
        }

        return firstLetters.equals(secondLetters);
    }

    public static boolean isAnagram_Array(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }


    public static boolean isAnagram_HashMap_V2(String s, String t) { // не работает
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            letters.put(s.charAt(i), letters.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            letters.put(t.charAt(i), letters.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer count : letters.values()) {
            if (count!= 0) return false;
        }
        return true;
    }


}

