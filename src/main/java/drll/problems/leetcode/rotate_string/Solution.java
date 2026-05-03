package drll.problems.leetcode.rotate_string;


public class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == goal.charAt(0)){
                if(checkMatch(s, goal, i)) {
                     return s.substring(0, i).equals(
                             goal.substring(s.length() - i));
                }
            }
        }
        return false;
    }

    private boolean checkMatch(String s, String goal, int i) {
        for(int j = i; j < goal.length(); j++) {
            if(s.charAt(j) != goal.charAt(j - i)){
                return false;
            }
        }
        return true;
    }
}