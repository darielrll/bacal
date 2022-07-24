package drll.problems.leetcode.FirstLetterToAppearTwice;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if(set.contains(character)){
                return character;
            }
            else {
                set.add(character);
            }
        }
        return ' ';
    }
}