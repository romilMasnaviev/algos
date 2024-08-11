package ru.masnaviev.arraysAndHashing;

import java.util.*;

public class TopKFrequentElements {
    //Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//k is in the range [1, the number of unique elements in the array].
//It is guaranteed that the answer is unique.
//
//
//Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int[] result1 = topKFrequent_First(arr, 2);
        int[] result2 = topKFrequent_Second(arr, 2);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        for (int num : result2) {
            System.out.print(num + " ");
        }


    }

    public static int[] topKFrequent_First(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(k);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).mapToInt(Map.Entry::getKey).toArray();
    }

    public static int[] topKFrequent_Second(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(k);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int entry: map.keySet()) {
            heap.add(entry);
            if (heap.size() > k) heap.poll();
        }

        int[] top = new int[k];

        for (int i = k -1; i >= 0; i--){
            top[i]=heap.poll();
        }

        return top;
    }
}
