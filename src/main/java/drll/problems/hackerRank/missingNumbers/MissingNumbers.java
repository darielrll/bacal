
package drll.problems.hackerRank.missingNumbers;

import java.io.*;
import java.util.*;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] missing, int[] original) {

        HashMap<Integer, Integer> originalNumbersMap = getMapAnalisis(original);
        HashMap<Integer, Integer> missingNumbersMap = getMapAnalisis(missing);

        ArrayList<Integer> missingNumbers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : originalNumbersMap.entrySet()) {
            if (!missingNumbersMap.containsKey(entry.getKey())  ||
                (missingNumbersMap.containsKey(entry.getKey())  &&  !missingNumbersMap.get(entry.getKey()).equals(entry.getValue()))){
                missingNumbers.add(entry.getKey());
            }
        }

        int[] result = new int[missingNumbers.size()];
        for (int i = 0; i < missingNumbers.size(); i++) {
            result[i] = missingNumbers.get(i);
        }

        Arrays.sort(result);


        return result;
    }

    private static HashMap<Integer, Integer> getMapAnalisis(int[] numbers) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();

        for (int i : numbers) {
            if (numbersMap.containsKey(i)){
                numbersMap.put(i, numbersMap.get(i) + 1);
            }
            else{
                numbersMap.put(i, 1);
            }
        }

        return numbersMap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}