
package drll.problems.hacker_rank.contacts;

import java.util.*;

public class Contacts {

    /*
     * Complete the contacts function below.
     */
    static Integer[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        Trie trie = new Trie();
        List<Integer> result = new ArrayList<>();
        for (String[] query : queries) {
            String op = query[0];
            String contact = query[1];

            if ("add".equalsIgnoreCase(op)) {
                trie.add(contact);
            } else if ("find".equalsIgnoreCase(op)) {
                int words = trie.findPartial(contact);
                result.add(words);
            } else {
                throw new IllegalArgumentException("Operation [%s] not supported.");
            }
        }
        return result.toArray(new Integer[0]);
    }
}
