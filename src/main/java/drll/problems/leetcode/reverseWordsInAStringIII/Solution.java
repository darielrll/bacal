package drll.problems.leetcode.reverseWordsInAStringIII;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        for (int i = 0, length = words.length; i < length; i++) {
            char[] wordCharacters = words[i].toCharArray();
            reverseString(wordCharacters, 0, wordCharacters.length - 1);

            words[i] = String.valueOf(wordCharacters);
        }

        return String.join(" ", words);
    }

    private void reverseString(char[] s, int start, int end){
        if(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            reverseString(s, start + 1, end - 1);
        }
    }
}