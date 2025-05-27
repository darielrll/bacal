package drll.problems.leetcode.jump_gameII;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        final int[] bfs = new int[nums.length];
        final Queue<Integer> visitor = new LinkedList<>();
        visitor.add(0);
        do {
            final Integer currentPosition = visitor.poll();
            for (int j = 1; j <= nums[currentPosition]; j++) {
                final int jump = currentPosition + j;
                if(jump < nums.length  &&  bfs[jump] == 0){
                    bfs[jump] = bfs[currentPosition] + 1;
                    if(jump == nums.length - 1){
                        return bfs[jump];
                    }
                    visitor.add(jump);
                }
            }
        }
        while (!visitor.isEmpty());
        return -1;
    }
}