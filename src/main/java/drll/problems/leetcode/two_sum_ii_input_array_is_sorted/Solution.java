package drll.problems.leetcode.two_sum_ii_input_array_is_sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, length = numbers.length; i < length; i++) {
            int secondAddend = target - numbers[i];
            int secondAddendPosition = search(numbers, secondAddend, 0, length - 1);
            if(secondAddendPosition != -1){
                return secondAddendPosition == i
                        ? new int[]{ i + 1, i + 2 }
                        : new int[]{ i + 1, secondAddendPosition + 1 };
            }
        }
        return null;
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middlePosition = (start + end) / 2;
        if(nums[middlePosition] == target){
            return middlePosition;
        }
        return nums[middlePosition] > target
                ? search(nums, target, start, middlePosition - 1)
                : search(nums, target, middlePosition + 1, end);
    }
}