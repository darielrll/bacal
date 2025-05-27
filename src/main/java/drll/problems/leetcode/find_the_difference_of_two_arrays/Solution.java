package drll.problems.leetcode.find_the_difference_of_two_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(complement(nums1, nums2));
        answer.add(complement(nums2, nums1));

        return answer;
    }

    private List<Integer> complement(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        int lengthB = b.length - 1;
        if (!contains(b, a[0], 0, lengthB)) {
            list.add(a[0]);
        }
        for (int i = 1; i < a.length; i++) {
            if(a[i] == a[i - 1]){
                continue;
            }
            if (!contains(b, a[i], 0, lengthB)) {
                list.add(a[i]);
            }
        }

        return list;
    }

    private boolean contains(int[] nums, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int middlePosition = (start + end) / 2;
        if (nums[middlePosition] == target) {
            return true;
        }
        return nums[middlePosition] > target
                ? contains(nums, target, start, middlePosition - 1)
                : contains(nums, target, middlePosition + 1, end);
    }
}