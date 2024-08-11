package ru.masnaviev.arraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1]
//Output: true
//Example 2:
//
//Input: nums = [1,2,3,4]
//Output: false
//Example 3:
//
//Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-109 <= nums[i] <= 109
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(containsDuplicate_hashMap(arr));
        System.out.println(containsDuplicate_native(arr));
        System.out.println(containsDuplicate_hashSet(arr));
        System.out.println(containsDuplicate_hashSet_V2(arr)); //Лучший

    }

    public static boolean containsDuplicate_hashMap(int[] nums) {
        HashMap<Integer, Object> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, null);
        }
        return map.size() == nums.length;
    }

    public static boolean containsDuplicate_native(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean containsDuplicate_hashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() == nums.length;
    }

    public static boolean containsDuplicate_hashSet_V2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}

