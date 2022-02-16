package drll.problems.leetcodeContest.Problem2;

public class Problem2 {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        boolean[] changeI = new boolean[nums.length];

        for (int i = 2; i < nums.length; i += 2) {
            if(nums[i - 2] != nums[i]  ||  changeI[i - 2]){
                changeI[i] = true;
            }
        }

        for (int i = 3; i < nums.length; i += 2) {
            if(nums[i - 2] != nums[i]  ||  changeI[i - 2]){
                changeI[i] = true;
            }
        }

        for (int i = 1; i < changeI.length; i++) {
            if(changeI[i]){
                operations++;
            }
        }
        return operations;
    }
}