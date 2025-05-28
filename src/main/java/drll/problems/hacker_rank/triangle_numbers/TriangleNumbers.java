
package drll.problems.hacker_rank.triangle_numbers;

public class TriangleNumbers {

    // Complete the solve function below.
    static int solve(int n) {

        if(n < 3){
            return -1;
        }
        if(n % 2 == 1){
            return 2;
        }

        if((n - 1) * n / 2 % 2 == 0){
            return 3;
        }
        return 4;
    }
}