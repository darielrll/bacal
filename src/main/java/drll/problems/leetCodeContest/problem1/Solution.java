package drll.problems.leetcodeContest.problem1;

import java.util.HashMap;

public class Solution {
    public String decodeMessage(String key, String message) {
        StringBuilder decodedMessage = new StringBuilder();

        HashMap<Character, Character> table = new HashMap<>();
        char firstLetter = 97;
        for (int i = 0; i < key.length(); i++) {
            Character character = key.charAt(i);
            if(!character.equals(' ')  &&  !table.containsKey(character)){
                table.put(character, firstLetter);
                firstLetter++;
            }
            if(firstLetter > 122){
                break;
            }
        }

        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' '){
                decodedMessage.append(' ');
            }
            else {
                decodedMessage.append(table.get(message.charAt(i)));
            }
        }

        return decodedMessage.toString();
    }
}