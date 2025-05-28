
package drll.problems.hacker_rank.array_manipulation;

import java.util.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries){

        HashMap<Integer, Long> list = new HashMap<>();

        for (int[] query : queries) {
            int start = query[0];
            int endPlusOne = query[1] + 1;
            int value = query[2];

            list.putIfAbsent(start, 0L);
            list.putIfAbsent(endPlusOne, 0L);

            list.put(start, list.get(start) + value);
            list.put(endPlusOne, list.get(endPlusOne) - value);
        }

        long cumulative = 0;
        long maxValue = 0;
        for (int i = 0; i <= n; i++) {
            if (list.containsKey(i)){
                cumulative += list.get(i);
            }
            if (maxValue < cumulative){
                maxValue = cumulative;
            }
        }

        return maxValue;
    }
}