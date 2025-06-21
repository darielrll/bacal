package drll.problems.leetcode.permutation_in_string;

import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        s2 += '*';
        final HashMap<Character, Integer> s1Characters = getCharacterIntegerHashMap(s1, 0 , s1.length() - 1);
        final boolean[] includedCharacters = getIncludedCharacters(s2, s1Characters);

        int s1PermutationLength = 0;
        int i = 0;
        while (i < includedCharacters.length) {
            if(includedCharacters[i]){
                s1PermutationLength++;
            }
            else{
                if(s1PermutationLength >= s1.length()){
                    if (containsPermutationInRange(s1, s2, i, s1PermutationLength, s1Characters))
                        return true;
                }
                else {
                    s1PermutationLength = 0;
                }
            }
            i++;
        }
        return false;
    }

    private boolean containsPermutationInRange(String s1, String s2, int i, int s1PermutationLength, HashMap<Character, Integer> s1Characters) {
        int s2startFinding = i - s1PermutationLength;
        HashMap<Character, Integer> rollingHashMap = getCharacterIntegerHashMap(s2, s2startFinding, s2startFinding + s1.length() - 1);
        do {
            if (s1Characters.equals(rollingHashMap)) {
                return true;
            }
            removeRollingCharacter(rollingHashMap, s2.charAt(s2startFinding));
            addRollingCharacter(rollingHashMap, s2.charAt(s2startFinding + s1.length()));
        } while (++s2startFinding <= i - s1.length());
        return false;
    }

    private static boolean[] getIncludedCharacters(String s2, HashMap<Character, Integer> s1Characters) {
        final boolean[] includedCharacters = new boolean[s2.length()];
        for (int i = 0, length = s2.length(); i < length; i++) {
            includedCharacters[i] = s1Characters.containsKey(s2.charAt(i));
        }
        return includedCharacters;
    }

    private void addRollingCharacter(HashMap<Character, Integer> rollingHashMap, Character charToInclude) {
        rollingHashMap.put(charToInclude, rollingHashMap.containsKey(charToInclude)
                ? rollingHashMap.get(charToInclude) + 1
                : 1);
    }

    private void removeRollingCharacter(HashMap<Character, Integer> rollingHashMap, Character charToExclude) {
        if (rollingHashMap.get(charToExclude) == 1) {
            rollingHashMap.remove(charToExclude);
        } else {
            rollingHashMap.put(charToExclude, rollingHashMap.get(charToExclude) - 1);
        }
    }

    private HashMap<Character, Integer> getCharacterIntegerHashMap(String s1, int start, int endIncluded) {
        HashMap<Character, Integer> s1Characters = new HashMap<>();
        for (int i = start; i <= endIncluded; i++) {
            addRollingCharacter(s1Characters, s1.charAt(i));
        }
        return s1Characters;
    }
}