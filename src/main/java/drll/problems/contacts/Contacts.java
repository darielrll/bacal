
package drll.problems.contacts;

import java.util.*;

public class Contacts {

    static void executeOperation(Trie trie, String op, String contact){
        if("add".equalsIgnoreCase(op)){
            trie.add(contact);
        }
        else if("find".equalsIgnoreCase(op)){
            int words = trie.findPartial(contact);
            System.out.println(words);
        }
        else{
            throw new IllegalArgumentException(String.format("Operation [%s] not supported."));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Trie trie = new Trie();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];

            executeOperation(trie, op, contact);
        }

        scanner.close();
    }
}
