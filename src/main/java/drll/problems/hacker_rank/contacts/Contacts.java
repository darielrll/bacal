
package drll.problems.hacker_rank.contacts;

import java.io.*;
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            System.arraycopy(queriesRowItems, 0, queries[queriesRowItr], 0, 2);
        }

        Integer[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
