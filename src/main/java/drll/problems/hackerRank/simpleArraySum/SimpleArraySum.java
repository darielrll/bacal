
package drll.problems.hackerRank.simpleArraySum;

import java.util.Scanner;

public class SimpleArraySum {

    /*
     * Complete the simpleArraySum function below.
     */
    public static int simpleArraySum(int[] ar) {
        int result = 0;
        for (int j : ar) result += j;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int arCount = Integer.parseInt(scanner.nextLine().trim());

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);

        System.out.println(result);
    }
}