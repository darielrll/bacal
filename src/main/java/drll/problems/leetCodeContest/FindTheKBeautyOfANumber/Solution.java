package drll.problems.leetCodeContest.FindTheKBeautyOfANumber;

public class Solution {
    public int divisorSubstrings(int num, int k) {
        int kBeauty = 0;

        String numberString = String.valueOf(num);
        for (int i = 0; i <= numberString.length() - k; i++) {
            String substring = i + k == numberString.length()
                    ? numberString.substring(i)
                    : numberString.substring(i, i + k);
            int candidateBeauty = Integer.parseInt(substring);
            if(candidateBeauty != 0  &&  num % candidateBeauty == 0){
                kBeauty++;
            }
        }

        return kBeauty;
    }
}