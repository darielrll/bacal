
package drll.problems.hacker_rank.compare_triplets;

public class CompareTriplets {

    // Complete the solve function below.
    static int[] solve(int[] a, int[] b) {

        int resultA = 0;
        int resultB = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] > b[i]) resultA++;
            else if(a[i] < b[i]) resultB++;
        }
        return new int[]{resultA, resultB};
    }
}