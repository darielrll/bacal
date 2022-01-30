package drll.dataStructures.Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private Node root;
    private int count;

    public Trie() {
        Character INITIAL_CHARACTER = '*';
        root = new Node(INITIAL_CHARACTER);
    }

    public int count() {
        return count;
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node current = root;
        for (int i = 0, length = chars.length; i < length; i++) {
            Node adjacent = current.getAdjacent(chars[i]);
            if (adjacent == null) {
                adjacent = new Node(chars[i]);
                current.adjacents.add(adjacent);
            }
            current = adjacent;
        }
        current.adjacents.add(new Node('#'));
        count++;
    }

    public boolean contains(String word) {
        char[] chars = (word + '#').toCharArray();
        Node current = root;
        for (char aChar : chars) {
            Node adjacent = current.getAdjacent(aChar);
            if (adjacent == null) {
                return false;
            }
            current = adjacent;
        }
        return true;
    }

    class Node {
        public Character character;
        public List<Node> adjacents;

        public Node(Character character) {
            this.character = character;
            adjacents = new ArrayList<>();
        }

        public Node getAdjacent(char character) {
            for (Node adjacent : adjacents) {
                if (adjacent.character.equals(character)) {
                    return adjacent;
                }
            }
            return null;
        }
    }
}
