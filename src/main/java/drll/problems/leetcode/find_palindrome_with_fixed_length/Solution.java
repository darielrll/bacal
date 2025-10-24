package drll.problems.leetcode.find_palindrome_with_fixed_length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        HashMap<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            cache.computeIfAbsent(queries[i], k -> new ArrayList<>()).add(i);
        }

        List<Long> kthPalindrome = getKthPalindrome(queries, intLength);

        long[] result = new long[queries.length];
        Arrays.fill(result, -1L);

        for(int i = 0; i < kthPalindrome.size(); i++) {
            for(Integer index : cache.get(queries[i])) {
                result[index] = kthPalindrome.get(i);
            }
        }
        return result;
    }

    String getFirstPalindromeOfLength(int intLength) {
        if (intLength == 1) {
            return "1";
        }
        return "1" + "0".repeat(intLength - 2) + "1";
    }

    private long getMaxAmountOfPalindromes(int intLength) {
        int half = intLength / 2;
        if (intLength % 2 == 1) {
            return 9L * (long) Math.pow(10, half);
        }
        return 9L * (long) Math.pow(10, half - 1);
    }

    private static String getPalindromeOneLength(Integer palindrome, int nth_times) {
        if(nth_times == 0){
            return String.valueOf(palindrome);
        }
        if(palindrome == 9  && nth_times == 1){
            return "11";
        }
        return getPalindromeOneLength(palindrome + 1, nth_times - 1);
    }

    private List<Long> getKthPalindrome(int[] queries, int intLength) {
        Arrays.sort(queries);
        List<Long> answer = new ArrayList<>();

        int currentIndex = 0;
        String currentPalindrome = getFirstPalindromeOfLength(intLength);
        long maxAmountOfPalindromes = getMaxAmountOfPalindromes(intLength);
        for (int query : queries) {
            if (query > maxAmountOfPalindromes) {
                break;
            }
            currentPalindrome = getNextPalindrome(currentPalindrome, (query - 1) - currentIndex);
            currentIndex = query - 1;
            if (currentPalindrome.length() > intLength) {
                break;
            }
            answer.add(Long.parseLong(currentPalindrome));
        }

        return answer;
    }

    String getNextPalindrome(String palindrome) {
        return getNextPalindrome(palindrome, 1);
    }

    String getNextPalindrome(String palindrome, int nth_times) {
        if(nth_times == 0){
            return palindrome;
        }
        if(palindrome.length() == 1){
            return getPalindromeOneLength(Integer.parseInt(palindrome), nth_times);
        }
        if(isLastPalindromeOfLength(palindrome)) {
            return getFirstPalindromeOfLength(palindrome.length() + 1);
        }
        if(palindrome.length() % 2 == 1){
            return getPalindromeOddLength(palindrome, nth_times);
        }
        return getPalindromeEvenLength(palindrome, nth_times);
    }

    private String getPalindromeOddLength(String palindrome, int nthTimes) {
        char[] leftPart = palindrome.substring(0, palindrome.length() / 2 + 1).toCharArray();
        int leftNumber = Integer.parseInt(String.valueOf(leftPart));
        int leftNthNumber = leftNumber + nthTimes;

        if(leftNthNumber >= Math.pow(10, leftPart.length)) {
            return  buildEvenPalindrome(leftNthNumber);
        }
        return buildOddPalindrome(leftNthNumber);
    }

    private String getPalindromeEvenLength(String palindrome, int nthTimes) {
        char[] leftPart = palindrome.substring(0, palindrome.length() / 2).toCharArray();
        int leftNumber = Integer.parseInt(String.valueOf(leftPart));
        int leftNthNumber = leftNumber + nthTimes;

        return buildEvenPalindrome(leftNthNumber);
    }

    private static boolean isLastPalindromeOfLength(String palindrome) {
        for (int i = 0; i < palindrome.length(); i++) {
            if(palindrome.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }

    private static String buildOddPalindrome(int leftNthNumber) {
        String left = String.valueOf(leftNthNumber);
        String right = new StringBuilder(left.substring(0, left.length() - 1)).reverse().toString();
        return left + right;
    }

    private static String buildEvenPalindrome(int leftNthNumber) {
        return String.valueOf(leftNthNumber) + new StringBuilder(String.valueOf(leftNthNumber)).reverse();
    }
}