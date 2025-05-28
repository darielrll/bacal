
package drll.problems.hacker_rank.largest_rectangle;

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
}