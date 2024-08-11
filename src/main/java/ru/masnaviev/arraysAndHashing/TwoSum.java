package ru.masnaviev.arraysAndHashing;


import java.util.Arrays;
import java.util.HashMap;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        Example 2:
//
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        Example 3:
//
//        Input: nums = [3,3], target = 6
//        Output: [0,1]
//
//
//        Constraints:
//
//        2 <= nums.length <= 104
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109
//        Only one valid answer exists.
//
//
//        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum_native(nums, target)));
        System.out.println(Arrays.toString(twoSum_rightWay(nums, target)));
    }

    public static int[] twoSum_native(int[] nums, int target) { // нативный способ
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int numsI = nums[i];
            for (int j = i + 1; j < length; j++) {
                if (numsI + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Суть - циклом проходим по массиву, и смотрим, есть ли в мапе значение которого нам не хвататет
    // (если сложить текущее nums[i] и значение из мапы, то получится нужное нам)
    // работает быстро так как поиск в мапе и её заполнение O(n)
    public static int[] twoSum_rightWay(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
