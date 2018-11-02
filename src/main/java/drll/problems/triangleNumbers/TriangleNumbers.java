
package drll.problems.triangleNumbers;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

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

    // Complete the solve function below.
    static int solve_Naive(int n) {

        if(n < 3){
            return -1;
        }
        if(n % 2 == 1){
            return 2;
        }

        boolean[] rowStart = {false, true, false};
        boolean[] rowNext = null;
        while(n-- > 3){
            rowNext = new boolean[rowStart.length + 1];
            for (int i = 1; i < rowNext.length - 1; i++) {
                boolean upperLeft = true;
                if(i - 2 >= 0){
                    upperLeft = rowStart[i - 2];
                }
                boolean upper = rowStart[i - 1];
                boolean upperRigth = rowStart[i];
                rowNext[i] = upperLeft == upper == upperRigth;
            }
            rowStart = rowNext;
        }
        for (int i = 1; i < rowNext.length; i++) {
            if(rowNext[i]){
                return i + 1;
            }
        }

        return -1;
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