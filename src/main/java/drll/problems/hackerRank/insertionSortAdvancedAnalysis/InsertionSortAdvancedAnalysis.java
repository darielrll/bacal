
package drll.problems.hackerRank.insertionSortAdvancedAnalysis;

import java.util.Scanner;

public class InsertionSortAdvancedAnalysis {

    public static long insertionSort(int[] arr) {
        AVLTreeInsertionAnalysis tree = new AVLTreeInsertionAnalysis();
        for (int i = 0; i < arr.length; i++){
            tree.add(new InsertionAnalysis(arr[i]));
        }
        return tree.getShifts();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = insertionSort(arr);

            System.out.println(result);
        }
        scanner.close();
    }
}