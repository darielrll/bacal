
package drll.problems.largestRectangle;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

        long largestArea = 0;

        HashMap<Integer, Integer> segments = new HashMap<>();
        for (int i = 0; i < h.length; i++) {
            if(segments.containsKey(h[i])){
                continue;
            }
            int startPoint = i;
            for (int j = startPoint - 1; j >= 0; j--) {
                if (h[i] <= h[j]){
                    startPoint = j;
                }
                else{
                    break;
                }
            }
            int endPoint = i;
            for (int j = endPoint + 1; j < h.length; j++) {
                if (h[i] <= h[j]){
                    endPoint = j;
                }
                else{
                    break;
                }
            }
            long tmpArea = h[i] * (endPoint - startPoint + 1);
            if(tmpArea > largestArea){
                largestArea = tmpArea;
            }
            segments.put(h[i], endPoint - startPoint + 1);
        }

        return largestArea;
    }

    static long largestRectangle_n2(int[] h) {
        // rise time out in some test cases
        long largestArea = 0;

        for (int i = 0; i < h.length; i++) {
            int minHeight = h[i];
            for (int j = i + 1; j < h.length; j++) {
                minHeight = Math.min(minHeight, h[j]);
                long tmpArea = (j - i + 1) * minHeight;
                if (tmpArea > largestArea){
                    largestArea = tmpArea;
                }
            }
        }

        return largestArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}