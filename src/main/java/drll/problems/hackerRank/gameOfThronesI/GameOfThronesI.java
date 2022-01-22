
package drll.problems.hackerRank.gameOfThronesI;

import java.util.HashSet;
import java.util.Set;

public class GameOfThronesI {

    public static String gameOfThrones(String anagram) {
        Set<Character> box = new HashSet<>();

        for(int i = 0, n = anagram.length() ; i < n ; i++) {
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