
package drll.problems.contacts;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

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
        for(int i = 0; i < queries.length; i++){
            String op = queries[i][0];
            String contact = queries[i][1];

            if("add".equalsIgnoreCase(op)){
                trie.add(contact);
            }
            else if("find".equalsIgnoreCase(op)){
                int words = trie.findPartial(contact);
                result.add(words);
            }
            else{
                throw new IllegalArgumentException(String.format("Operation [%s] not supported."));
            }
        }
        return result.toArray(new Integer[result.size()]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
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
