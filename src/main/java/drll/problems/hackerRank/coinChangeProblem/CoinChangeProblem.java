
package drll.problems.hackerRank.coinChangeProblem;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChangeProblem {

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {

        //return getWays(n, c, 0);
        //HashMap<Long, Long> result = new HashMap<>();
        return getWaysDinamicProgramming(n, c, 0, new HashMap<>());
    }

    // Complete the getWays function below.
    static long getWaysRecursiveOnly(long n, long[] c, int coinIndex) {

        if(n == 0){
            return 1;
        }
        if(n < 0  || coinIndex >= c.length){
            return 0;
        }
        return getWaysRecursiveOnly(n - c[coinIndex], c, coinIndex) +
                getWaysRecursiveOnly(n, c, coinIndex + 1);
    }

    // Complete the getWays function below.
    // change, coin, ways
    static long getWaysDinamicProgramming(long n, long[] c, int coinIndex,
                                          HashMap<Long, HashMap<Long, Long>> results) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        results.putIfAbsent(n, new HashMap<>());
        results.putIfAbsent(n - c[coinIndex], new HashMap<>());

        long usingCoin;
        if(results.get(n - c[coinIndex]).containsKey(c[coinIndex])){
            usingCoin = results.get(n - c[coinIndex]).get(c[coinIndex]);
        }
        else {
            usingCoin = getWaysDinamicProgramming(n - c[coinIndex], c, coinIndex, results);
            results.get(n - c[coinIndex]).put(c[coinIndex], usingCoin);
        }


        long notUsingCoin = 0;
        if(coinIndex + 1 < c.length) {
            if(results.get(n).containsKey(c[coinIndex + 1])){
                notUsingCoin = results.get(n).get(c[coinIndex + 1]);
            }
            else {
                notUsingCoin = getWaysDinamicProgramming(n, c, coinIndex + 1, results);
                results.get(n).put(c[coinIndex + 1], notUsingCoin);
            }
        }

        return usingCoin + notUsingCoin;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);

        System.out.println(ways);

        scanner.close();
    }
}