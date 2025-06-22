package drll.problems.pending_solution.find_palindrome_with_fixed_length;

import drll.problems.pending_solution.find_palindrome_with_fixed_length.generators.PalindromeNumberIterator;

public class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] answer = new long[queries.length];

        PalindromeGenerator palindromeGenerator = new PalindromeGenerator(intLength);
        for (int i = 0; i < queries.length; i++) {
            String nextPalindrome = palindromeGenerator.nextPalindrome(queries[i]);
            if (nextPalindrome.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = Long.parseLong(nextPalindrome);
            }
        }


       /* PalindromeNumberIterator palindromeIterator = new PalindromeNumberIterator();
        int currentIndex = 1;
        for(int i = 0; i < queries.length; i++) {
            while (currentIndex < queries[i]) {
                palindromeIterator.next();
                currentIndex++;
            }
            String nextPalindrome = palindromeIterator.next();
            if (nextPalindrome.length() != intLength) {
                answer[i] = -1;
            } else {
                answer[i] = Long.parseLong(nextPalindrome);
            }
        }*/

        return answer;
    }

    static class PalindromeGenerator {
        private char[] currentPalindrome;
        private int currentNthPalindrome = 1;

        public PalindromeGenerator(int initialLength) {
            currentPalindrome = new char[initialLength];
            currentPalindrome[0] = '1';
            currentPalindrome[initialLength - 1] = '1';
            for (int i = 1; i < initialLength - 1; i++) {
                currentPalindrome[i] = '0';
            }
        }

        public String nextPalindrome(int nthPalindrome) {
            for (int i = currentNthPalindrome; i <= nthPalindrome; i++) {
                moveToNextPalindrome();
            }
            currentNthPalindrome = nthPalindrome;
            return new String(currentPalindrome);
        }

        private void moveToNextPalindrome() {
            int middleRightPosition = currentPalindrome.length / 2;
            int middleLeftPosition = middleRightPosition - 1;
            int number = Integer.parseInt(String.valueOf(currentPalindrome[middleRightPosition]));
            if (currentPalindrome.length % 2 == 0) {
                while (number == 9) {
                    middleRightPosition++;
                    middleLeftPosition--;
                    number = Integer.parseInt(String.valueOf(currentPalindrome[middleRightPosition]));
                }
                number++;
                currentPalindrome[middleLeftPosition] = (char) number;
                currentPalindrome[middleRightPosition] = (char) number;
            } else {
                if (number == 9) {
                    currentPalindrome[middleRightPosition] = (char) 0;
                    middleLeftPosition = middleRightPosition - 1;
                    middleRightPosition++;

                    number = Integer.parseInt(String.valueOf(currentPalindrome[middleRightPosition]));
                } else {
                    number++;
                    currentPalindrome[middleRightPosition] = (char) number;
                }
            }
        }
    }
}