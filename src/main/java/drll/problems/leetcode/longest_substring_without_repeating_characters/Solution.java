package drll.problems.leetcode.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int longest = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            for (int j = i; j < length; j++) {
                char character = s.charAt(j);
                if (characters.contains(character)){
                    break;
                }
                characters.add(character);
            }
            if(longest < characters.size()){
                longest = characters.size();
            }
            characters.clear();
        }
        return longest;
    }
}