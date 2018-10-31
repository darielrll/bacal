
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

        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < h.length; i++) {
            if (stack.isEmpty()  ||  h[stack.peek()] < h[i]){
                stack.push(i);
            } else {
                int lastTakenOutPosition = stack.pop();
                while (!stack.isEmpty()  &&  h[stack.peek()] > h[i]){
                    long area = h[stack.peek()] * (i - stack.peek());
                    if (area > largestArea){
                        largestArea = area;
                    }
                    lastTakenOutPosition = stack.pop();
                }
                h[lastTakenOutPosition] = h[i];
                stack.push(lastTakenOutPosition);
                long area = h[lastTakenOutPosition] * (i - lastTakenOutPosition + 1);
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
                long area = h[stack.peek()] * (endPosition - stack.peek() + 1);
                if (area > largestArea) {
                    largestArea = area;
                }
                stack.pop();
            }
        }

        return largestArea;
    }

    static long largestRectangle_n2_enhanced(int[] h) {
        long largestArea = 0;

        Set<Segment> segments = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            if(segments.contains(new Segment(i, i, h[i]))){
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
            segments.add(new Segment(startPoint, endPoint, h[i]));
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

class Segment{
    public int start, end, height;

    public Segment(int start, int end, int height) {
        this.start = start;
        this.end = end;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {

        if(o == null  ||  !(o instanceof Segment)){
            return false;
        }
        Segment other = (Segment)o;
        if (other.height != height){
            return false;
        }
        Segment first, second;
        if(start < other.start){
            first = this;
            second = other;
        }
        else{
            first = other;
            second = this;
        }
        // false if segments are not overlapped
        return (first.end - first.start) + (second.end - second.start) > (second.end - first.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, height);
    }
}