package drll.problems.leetcode.reverseString;

public class Solution {
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
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