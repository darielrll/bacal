
package drll.problems.hackerRank.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    public final Character character;
    public boolean isCompleteWord;
    public int words;
    public final HashMap<Character, Trie> children;

    public Trie() {
        this('*');
    }

    public Trie(char character) {
        this.character = character;
        children = new HashMap<>();
    }

    public void add(String contact){
        if(contact == null  ||  contact.isEmpty()){
            return;
        }
        List<Trie> contactPath = new ArrayList<>();
        contactPath.add(this);
        Trie prefixNode = this;
        int suffixIndex = 0;
        for (int i = 0; i < contact.length(); i++) {
            if(prefixNode.children.containsKey(contact.charAt(i))){
                prefixNode = prefixNode.children.get(contact.charAt(i));
                contactPath.add(prefixNode);
            }
            else {
                suffixIndex = i;
                break;
            }
        }
        for (int i = suffixIndex; i < contact.length(); i++) {
            Trie trie = new Trie(contact.charAt(i));
            prefixNode.children.put(contact.charAt(i), trie);
            contactPath.add(trie);
            prefixNode = trie;
        }
        if(prefixNode.isCompleteWord){
            return;
        }
        // update word count in each node in contact path
        for (int i = 0; i < contactPath.size() - 1; i++) {
            contactPath.get(i).words++;
        }
        prefixNode.isCompleteWord = true;
    }

    public int findPartial(String prefix){
        if(prefix == null  ||  prefix.isEmpty()){
            return 0;
        }
        Trie prefixNode = this;
        int suffix = 0;
        while (suffix < prefix.length()) {
            if(!prefixNode.children.containsKey(prefix.charAt(suffix))){
                return 0;
            }
            prefixNode = prefixNode.children.get(prefix.charAt(suffix++));
        }
        if(suffix == prefix.length()){
            return prefixNode.isCompleteWord ? prefixNode.words + 1 : prefixNode.words;
        }
        return 0;
    }
}