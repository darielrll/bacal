
package drll.problems.hackerRank.coinChangeProblem;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChangeProblem {

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {

        /*
        return getWays(n, c, 0);
        HashMap<Long, Long> result = new HashMap<>();
        */
        return getWaysDinamicProgramming(n, c, 0, new HashMap<>());
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
}