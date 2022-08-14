package drll.problems.leetCodeContest.problem2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public long countBadPairs(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        HashMap<Integer, Integer> repetitions = getRepeatitions(nums);

        long totalPairs = getTotalPairs(nums, repetitions);

        long goodPairs = 0;
        int startWindow = 0;
        int endWindow = 1;

        while (endWindow < nums.length){
            int numStart = nums[startWindow];
            int numEnd = nums[endWindow];

            if(numStart < numEnd){
                if(endWindow - startWindow == numEnd - numStart){
                    goodPairs += 1 + (endWindow - startWindow - 1);
                    endWindow++;
                }
                else {
                    startWindow = endWindow;
                    endWindow++;

//                    while (endWindow < nums.length - 1  &&  nums[endWindow] == nums[endWindow + 1]){
//                        endWindow++;
//                        totalPairs -= endWindow;
//                    }
//                    endWindow++;
                }
            }
            else{
                startWindow = endWindow;
                endWindow++;

//                while (endWindow < nums.length - 1  &&  nums[endWindow] == nums[endWindow + 1]){
//                    endWindow++;
//                    totalPairs -= endWindow;
//                }
//                endWindow++;
            }
        }

        return totalPairs - goodPairs;
    }

    private HashMap<Integer, Integer> getRepeatitions(int[] nums) {
        HashMap<Integer, Integer> repeat = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if(repeat.containsKey(value)){
                repeat.replace(value, repeat.get(value) + 1);
            }
            else{
                repeat.put(value, 1);
            }
        }
        return repeat;
    }

    private long getTotalPairs(int[] nums, HashMap<Integer, Integer> repetitions) {
        int length = nums.length;
        long totalPairs = (long) (length - 1) * (length) / 2;

        int startWindow = 0;
        int endWindow = 1;
        int numStart = nums[startWindow];
        int numEnd = nums[endWindow];

        boolean equalsInWindow = numStart == numEnd;

        Set<Integer> numsSet = new HashSet<>();
        while (endWindow < nums.length){
            if(numStart == numEnd){
                equalsInWindow = true;
                endWindow++;
                if(!numsSet.contains(numStart)){
                    numsSet.add(numStart);
                }
            }
            else {
                if(equalsInWindow){
                    int repetition = endWindow - startWindow;

                    int pairBeforeWindow = startWindow;
                    int repetitionBeforeWindow = repetition * pairBeforeWindow - pairBeforeWindow;

                    int pairAfterWindow = nums.length - endWindow + 1;
                    int repetitionAfterWindow = repetition * pairAfterWindow - pairAfterWindow;

                    int repetitions

                    totalPairs -=

                    equalsInWindow = false;
                }
                else{
                    startWindow = endWindow;
                    endWindow++;
                }
            }

            numStart = nums[startWindow];
            numEnd = nums[endWindow];
        }

        return totalPairs;
    }
}