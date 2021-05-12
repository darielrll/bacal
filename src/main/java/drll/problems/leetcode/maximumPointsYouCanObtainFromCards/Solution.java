package drll.problems.leetcode.maximumPointsYouCanObtainFromCards;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int cardsToTake = k;
        if(k > cardPoints.length / 2){
            for (int i = cardPoints.length - k; i <= k - 1; i++) {
                max += cardPoints[i];
            }
            cardsToTake = cardPoints.length - k;
        }
        return Math.max(
                max + maxScore(cardPoints, cardsToTake, 0, cardPoints.length - 1),
                maxScore(cardPoints, k, 0, cardPoints.length - 1)
        );
    }

    private int maxScore(int[] cardPoints, int k, int init, int end) {
        if(k == 0){
            return 0;
        }
        return Math.max(
                cardPoints[end] + maxScore(cardPoints, k - 1, init, end - 1),
                cardPoints[init] + maxScore(cardPoints, k - 1, init + 1, end)
        );
    }

//    private int maxScore(int[] cardPoints, int k, int init, int end) {
//        if(k == 0){
//            return 0;
//        }
//        if(cardPoints[init] > cardPoints[end]){
//            return cardPoints[init] + maxScore(cardPoints, k - 1, init + 1, end);
//        }
//        return cardPoints[end] + maxScore(cardPoints, k - 1, init, end - 1);
//    }
}