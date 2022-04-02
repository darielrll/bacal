package drll.dataStructures.generators;

import java.util.Iterator;

public class PalindromeNumberIterator implements Iterator<String> {
    private char[] palindrome;

    public PalindromeNumberIterator() {
        this.palindrome = new char[]{'0'};
    }

    public PalindromeNumberIterator(String number) {
        palindrome = number.toCharArray();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        int middlePosition = palindrome.length / 2;
        int leftPosition = middlePosition - 1;
        int number = Integer.parseInt(String.valueOf(palindrome[middlePosition]));

        if (number < 9) {
            if (palindrome.length % 2 == 0) {
                palindrome[middlePosition] = Character.forDigit(++number, 10);
                palindrome[leftPosition] = Character.forDigit(number, 10);
            } else {
                palindrome[middlePosition] = Character.forDigit(++number, 10);
            }
        } else {
            if (leftPosition < 0) {
                palindrome = initFistPalindromeOfLengthN(palindrome.length + 1);
            } else {
                if(number < 9){

                }
                else{
                    int leftNumber = Integer.parseInt(String.valueOf(palindrome[leftPosition]));
                    while (leftNumber == 9){

                    }
                    palindrome = initFistPalindromeOfLengthN(palindrome.length + 1);
                }
            }
        }

        return new String(palindrome);
    }

    private char[] initFistPalindromeOfLengthN(int palindromeLength) {
        char[] tmp = new char[palindromeLength];
        tmp[0] = '1';
        tmp[tmp.length - 1] = '1';
        for (int i = 1; i < tmp.length - 1; i++) {
            tmp[i] = '0';
        }
        return tmp;
    }

    public String currentPalindrome() {
        return new String(palindrome);
    }
}
