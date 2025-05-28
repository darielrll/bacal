package drll.problems.leetcode.removing_stars_from_a_string;

import java.util.LinkedList;

public class Solution {
    public String removeStars(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if('*' == character){
                if(!stack.isEmpty()){
                    stack.removeLast();
                }
            }
            else {
                stack.add(character);
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (Character character : stack) {
            buffer.append(character);
        }

        return buffer.toString();
    }
}