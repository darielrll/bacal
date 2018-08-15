
package drll.problems.coinChangeProblem;

import java.util.Scanner;

public class CoinChangeProblem {

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {

        return getWays(n, c, 0);
    }

    // Complete the getWays function below.
    static long getWays(long n, long[] c, int coinIndex) {

        if(n == 0){
            return 1;
        }
        if(n < 0  || coinIndex >= c.length){
            return 0;
        }
        return getWays(n - c[coinIndex], c, coinIndex) +
               getWays(n, c, coinIndex + 1);
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