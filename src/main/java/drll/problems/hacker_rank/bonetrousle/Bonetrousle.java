
package drll.problems.hacker_rank.bonetrousle;

import java.io.*;
import java.util.*;

public class Bonetrousle {
    /*
     * Complete the bonetrousle function below.
     */
    static long[] bonetrousle(long sticksToBuy, long boxesForSale, int numberOfBoxesToBuy) {

        if( demandIsNotSupported(sticksToBuy, boxesForSale) ){
            return notValidCombination();
        }
        if(buyOnlyOneBox(numberOfBoxesToBuy)) {
            if(existBoxWithSticksToBuy(sticksToBuy, boxesForSale)) {
                return new long[]{sticksToBuy};
            }
            else {
                return notValidCombination();
            }
        }

        long currentSummation = 0L;
        List<Integer> tentativeBoxesToBuy = new ArrayList<>();
        for (int i = 1; i <= boxesForSale; i++) {
            currentSummation += i;
            tentativeBoxesToBuy.add(i);
            if(currentSummation >= sticksToBuy){
                break;
            }
        }

        if(tentativeBoxesNotSupportDemand(sticksToBuy, numberOfBoxesToBuy, currentSummation, tentativeBoxesToBuy)) {
            return notValidCombination();
        }

        int removedBox = (int) (currentSummation - sticksToBuy);
        long[] boxesToBuy = new long[numberOfBoxesToBuy];
        boxesToBuy[boxesToBuy.length - 1] = 0L;

        for (int i = 0, positionCovered = 0; i < tentativeBoxesToBuy.size(); i++) {
            if(tentativeBoxesToBuy.get(i) == removedBox) {
                continue;
            }
            if(positionCovered < boxesToBuy.length - 1) {
                boxesToBuy[positionCovered] = Long.valueOf(tentativeBoxesToBuy.get(i));
                positionCovered++;
            }
            else {
                boxesToBuy[boxesToBuy.length - 1] += tentativeBoxesToBuy.get(i);
            }
        }

        return boxesToBuy;
    }

    private static boolean tentativeBoxesNotSupportDemand(long sticksToBuy, int numberOfBoxesToBuy,
                                                        Long summation, List<Integer> tentativeBoxesToBuy) {
        /*
         * If summation is different from sticksToBuy means that is need to remove one
         * of the tentative boxes, and the box to remove is the box resulting from the
         * difference summation - sticksToBuy, so, there is no possible combination when
         * tentative boxes - 1 is less than the number of boxes to buy.
         */
        return summation != sticksToBuy  &&  tentativeBoxesToBuy.size() - 1 < numberOfBoxesToBuy;
    }

    private static boolean demandIsNotSupported(long sticksToBuy, long boxesForSale) {
        return sticksToBuy > availableSticksToBuy(boxesForSale);
    }

    private static boolean existBoxWithSticksToBuy(long sticksToBuy, long boxesForSale) {
        return sticksToBuy <= boxesForSale;
    }

    private static boolean buyOnlyOneBox(int numberOfBoxesToBuy) {
        return numberOfBoxesToBuy == 1;
    }

    private static long[] notValidCombination() {
        return new long[]{ -1L};
    }

    private static long availableSticksToBuy(long boxesForSale) {
        return boxesForSale * ( boxesForSale + 1 ) / 2;
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

            long[] result = bonetrousle(n, k, b);

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
