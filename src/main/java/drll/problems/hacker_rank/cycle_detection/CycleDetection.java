
package drll.problems.hacker_rank.cycle_detection;

import java.io.*;
import java.util.*;

public class CycleDetection {

    static class SinglyLinkedListNode {
        public final int data;
        private SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList   {
        private SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    // Complete the hasCycle function below.
    static boolean hasCycle(SinglyLinkedListNode head) {

        if(head == null){
            return false;
        }

        HashSet<SinglyLinkedListNode> visited = new HashSet<>();

        while (head != null){
            if(visited.contains(head)){
                return true;
            }
            visited.add(head);
            head = head.next;
        }

        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int tests = scanner.nextInt();
            String patternToSkip = "(\r\n|[\n\r\u2028\u2029\u0085])?";
            scanner.skip(patternToSkip);

            for (int testsItr = 0; testsItr < tests; testsItr++) {
                int index = scanner.nextInt();
                scanner.skip(patternToSkip);

                SinglyLinkedList list = new SinglyLinkedList();

                int listCount = scanner.nextInt();
                scanner.skip(patternToSkip);

                for (int i = 0; i < listCount; i++) {
                    int listItem = scanner.nextInt();
                    scanner.skip(patternToSkip);

                    list.insertNode(listItem);
                }

                SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
                SinglyLinkedListNode temp = list.head;

                for (int i = 0; i < listCount; i++) {
                    if (i == index) {
                        extra = temp;
                    }

                    if (i != listCount - 1) {
                        temp = temp.next;
                    }
                }

                temp.next = extra;

                boolean result = hasCycle(list.head);

                bufferedWriter.write(String.valueOf(result ? 1 : 0));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }

        scanner.close();
    }
}