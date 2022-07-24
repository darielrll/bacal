package drll.problems.leetcode.RearrangeCharactersToMakeTargetString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int rearrangeCharacters(String s, String target) {
        if(s.length() < target.length()){
            return 0;
        }

        HashMap<Character, Integer> targetCharCount = getCharacterIntegerHashMap(target);

        HashMap<Character, Integer> sCharCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if(targetCharCount.containsKey(charAt)){
                if(sCharCount.containsKey(charAt)){
                    sCharCount.put(charAt, sCharCount.get(charAt) + 1);
                }
                else {
                    sCharCount.put(charAt, 1);
                }
            }
        }

        if(sCharCount.size() != targetCharCount.size()){
            return 0;
        }

        int maximumNumber = 1000;
        for (Map.Entry<Character, Integer> entry : sCharCount.entrySet()) {
            if(maximumNumber > entry.getValue() / targetCharCount.get(entry.getKey())){
                maximumNumber = entry.getValue() / targetCharCount.get(entry.getKey());
            }
        }

        return maximumNumber;
    }

    private HashMap<Character, Integer> getCharacterIntegerHashMap(String target) {
        HashMap<Character, Integer> targetCharCount = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char charAt = target.charAt(i);
            if(targetCharCount.containsKey(charAt)){
                targetCharCount.put(charAt, targetCharCount.get(charAt) + 1);
            }
            else {
                targetCharCount.put(charAt, 1);
            }
        }
        return targetCharCount;
    }
}