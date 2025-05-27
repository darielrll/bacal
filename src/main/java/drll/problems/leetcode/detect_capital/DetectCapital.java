
package drll.problems.leetcode.detect_capital;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(Character.isLowerCase(word.charAt(0))){
            return areAllLowerCase(word);
        }
        if(word.length() == 1){
            return true;
        }
        return Character.isUpperCase(word.charAt(1))
                ? areAllCapital(word)
                : areAllLowerCase(word);
    }

    boolean areAllCapital(String word){
        for(int i = 2, length = word.length(); i < length ; i++) {
            if(Character.isLowerCase(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

    boolean areAllLowerCase(String word){
        for(int i = 1, length = word.length(); i < length ; i++) {
            if(Character.isUpperCase(word.charAt(i))){
                return false;
            }
        }
        return true;
    }
}