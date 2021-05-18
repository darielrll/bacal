
package drll.problems.hackerRank.arrayManipulation;

import java.io.*;
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}