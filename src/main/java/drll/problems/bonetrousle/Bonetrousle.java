
package drll.problems.bonetrousle;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Bonetrousle {
    /*
     * Complete the bonetrousle function below.
     */
    static Long[] bonetrousle(long buySticks, long storeBoxes, int buyBoxes) {
        /*
         * buyBoxes <= storeBoxes
         * 1 <= buyBoxes <= 10°5
         * 1 <= buySticks, storeBoxes <= 10°18
         */
        List<Long> combination = new ArrayList<>();
        if(findSumatoryCombinationOf(buyBoxes, buySticks, storeBoxes, combination)){
            return combination.toArray(new Long[combination.size()]);
        }
        return new Long[0];
    }

    static boolean findSumatoryCombinationOf(int nNumbers, long result, long from1To, List<Long> combination){
        if (nNumbers == 1){
            combination.add(result);
            return result <= from1To;
        }

        int minimumFrom1To = sumation(nNumbers - 1);

        if(result - minimumFrom1To > from1To){
            combination.add(from1To);
            if(result - from1To < from1To) {
                return findSumatoryCombinationOf(nNumbers - 1,
                        result - from1To,
                        result - from1To,
                        combination);
            }
            return findSumatoryCombinationOf(nNumbers - 1,
                    result - from1To,
                    from1To - 1,
                    combination);
        }
        if(result - (from1To - 1) <= 0){
            combination.add(result - 1);
            return findSumatoryCombinationOf(nNumbers - 1,
                    result - (result - 1),
                    result - (result - 1),
                    combination);
        }
        combination.add(from1To - 1);
        return findSumatoryCombinationOf(nNumbers - 1,
                                        result - (from1To - 1),
                                        result - (from1To - 1),
                                        combination);
    }

    static int sumation(int n){
        return n * (n + 1) / 2;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nkb = scanner.nextLine().split(" ");

            long n = Long.parseLong(nkb[0].trim());

            long k = Long.parseLong(nkb[1].trim());

            int b = Integer.parseInt(nkb[2].trim());

            Long[] result = bonetrousle(n, k, b);

            if(result.length == 0){
                bufferedWriter.write("-1");
            }
            else {
                for (int resultItr = 0; resultItr < result.length; resultItr++) {
                    bufferedWriter.write(String.valueOf(result[resultItr]));

                    if (resultItr != result.length - 1) {
                        bufferedWriter.write(" ");
                    }
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
