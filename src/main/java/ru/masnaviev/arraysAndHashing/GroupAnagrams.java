package ru.masnaviev.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//        Example 1:
//
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//        Example 2:
//
//        Input: strs = [""]
//        Output: [[""]]
//        Example 3:
//
//        Input: strs = ["a"]
//        Output: [["a"]]
//
//
//        Constraints:
//
//        1 <= strs.length <= 104
//        0 <= strs[i].length <= 100
//        strs[i] consists of lowercase English letters.
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams_V2(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) { //лучшее решение, сделал сам :)

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) { //сложность O(n) где n - количество элементов
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr); // сложность O(nlog(n)) где n - количество букв в каждом слове в основном слова не длиннее 4-х символов
            String sortedStr = String.valueOf(strArr);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>()); // сложность O(1)
            list.add(str); // сложность O(1)
            map.put(sortedStr, list); //сложность O(1)
        }
        return new ArrayList<>(map.values());
        //итоговая сложность - O(n)
    }

    public static List<List<String>> groupAnagrams_V2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) { //сложность O(n) где n - количество элементов
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr); // сложность O(m^2) где n - количество букв они обычно не более 5-ти символов
            String sortedStr = new String(strArr);
            map.putIfAbsent(sortedStr,new ArrayList<>()); // сложность O(1)
            map.get(sortedStr).add(str); // сложность O(1)
        }
        return new ArrayList<>(map.values());
        //итоговая сложность - O(n*m^2)?
    }
}
