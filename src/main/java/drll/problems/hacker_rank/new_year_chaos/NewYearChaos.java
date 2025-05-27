
package drll.problems.hacker_rank.new_year_chaos;

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int bribes = calculateBribes(q);
        if(bribes >= 0){
            System.out.println(bribes);
        }
        else{
            System.out.println("Too chaotic");
        }

    }

    static int calculateBribes(int[] q) {

        AVLExtended avlExtended = new AVLExtended();

        int bribes = 0;
        for (int i = 0; i < q.length; i++){
            int currentBribes = (i + 1) - q[i];
            if(currentBribes < 0) {
                if (currentBribes < -2) {
                    return -1;
                }
                bribes += currentBribes * -1;
            }
            else{
                avlExtended.add(new AVLNodeExtended(q[i]));
            }
        }
        return bribes + avlExtended.getBribes();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}



