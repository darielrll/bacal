
package drll.problems.hacker_rank.simple_array_sum;

public class SimpleArraySum {

    /*
     * Complete the simpleArraySum function below.
     */
    public static int simpleArraySum(int[] ar) {
        int result = 0;
        for (int j : ar) result += j;
        return result;
    }
}