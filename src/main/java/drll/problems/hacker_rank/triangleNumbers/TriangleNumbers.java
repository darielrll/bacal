
package drll.problems.hacker_rank.triangleNumbers;

import java.io.*;
import java.util.*;

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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = solve(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}