
package drll.problems.hacker_rank.largest_rectangle;

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
                    largestArea = updateLargestArea(h[stack.peek()], i - stack.peek(), largestArea);
                    lastTakenOutPosition = stack.pop();
                }
                h[lastTakenOutPosition] = h[i];
                stack.push(lastTakenOutPosition);
                largestArea = updateLargestArea(h[lastTakenOutPosition], i - lastTakenOutPosition + 1, largestArea);
            }
        }
        if (stack.size() > 1) {
            int endPosition = stack.pop();
            if (h[endPosition] > largestArea) {
                largestArea = h[endPosition];
            }
            while (!stack.isEmpty()){
                largestArea = updateLargestArea(h[stack.peek()], endPosition - stack.pop() + 1, largestArea);
            }
        }

        return largestArea;
    }

    private static long updateLargestArea(int a, int b, long largestArea){
        long area = calculateRectangleArea(a, b);
        return Math.max(area, largestArea);
    }

    private static long calculateRectangleArea(int a, int b){
        return (long) a * b;
    }
}