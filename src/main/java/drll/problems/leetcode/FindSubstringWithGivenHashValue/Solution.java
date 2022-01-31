package drll.problems.leetcode.FindSubstringWithGivenHashValue;

public class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int[] pows = new int[k];
        for (int i = 0; i < k; i++){
            pows[i] = (int) (Math.pow(power, i) % modulo);
        }

        for (int i = 0, length = s.length() - k + 1; i < length; i++) {
            String substring = s.substring(i, i + k);

            int subStringHash = 0;
            for (int j = 0; j < k; j++) {
                subStringHash += (substring.charAt(j) - 'a' + 1) * pows[j] % modulo;
            }

            if(subStringHash % modulo == hashValue){
                return substring;
            }
        }
        return null;
    }
}
