package drll.problems.leetcodeContest.Problem1;

public class Problem1 {
    public int countOperations(int num1, int num2) {
        int operations = 0;

        while (num1 != 0  &&  num2 != 0){
            if(num1 >= num2){
                num1 -= num2;
            }
            else{
                num2 -= num1;
            }
            operations++;
        }

        return operations;
    }
}