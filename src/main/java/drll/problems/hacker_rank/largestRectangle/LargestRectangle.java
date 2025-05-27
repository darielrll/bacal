
package drll.problems.hacker_rank.largestRectangle;

import java.io.*;
import java.util.*;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

        long largestArea = 0;

        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < h.length; i++) {
            if (stack.isEmpty()  ||  h[stack.peek()] < h[i]){
                stack.push(i);
            } else {
                int lastTakenOutPosition = stack.pop();
                while (!stack.isEmpty()  &&  h[stack.peek()] > h[i]){
                    long area = (long) h[stack.peek()] * (i - stack.peek());
                    if (area > largestArea){
                        largestArea = area;
                    }
                    lastTakenOutPosition = stack.pop();
                }
                h[lastTakenOutPosition] = h[i];
                stack.push(lastTakenOutPosition);
                long area = (long) h[lastTakenOutPosition] * (i - lastTakenOutPosition + 1);
                if (area > largestArea){
                    largestArea = area;
                }
            }
        }
        if (stack.size() > 1) {
            int endPosition = stack.pop();
            if (h[endPosition] > largestArea) {
                largestArea = h[endPosition];
            }
            while (!stack.isEmpty()){
                long area = (long) h[stack.peek()] * (endPosition - stack.peek() + 1);
                if (area > largestArea) {
                    largestArea = area;
                }
                stack.pop();
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