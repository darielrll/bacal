
package drll.problems.hacker_rank.game_of_thrones_i;

import java.util.HashSet;
import java.util.Set;

public class GameOfThronesI {

    public static String gameOfThrones(String anagram) {
        Set<Character> box = new HashSet<>();

        for(int i = 0, length = anagram.length(); i < length; i++) {
            Character character = anagram.charAt(i);
            if(box.contains(character)){
                box.remove(character);
            }
            else {
                box.add(character);
            }
        }

        return box.size() <= 1 ? "YES" : "NO";
    }
}