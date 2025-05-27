package drll.problems.leetcode.find_substring_with_given_hash_value;

public class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int[] pows = new int[k];
        for (int i = 0; i < k; i++){
            pows[i] = power(power, i, modulo);
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

    public static int power(int m, int n , int modulo ) {
        int i = 0;
        int result = 1;
        while(i++ < n) {
            result = (result * m) % modulo;
        }
        return result;
    }
}
