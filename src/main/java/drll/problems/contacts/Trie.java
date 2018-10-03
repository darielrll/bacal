
package drll.problems.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    public Character character;
    public boolean isCompleteWord;
    public int words;
    public HashMap<Character, Trie> childs;

    public Trie() {
        this('*');
    }

    public Trie(char character) {
        this.character = character;
        childs = new HashMap<>();
    }

    public void add(String contact){
        if(contact == null  ||  contact.isEmpty()){
            return;
        }
        List<Trie> contactPath = new ArrayList<>();
        contactPath.add(this);
        Trie prefixNode = this;
        int sufixIndex = 0;
        for (int i = 0; i < contact.length(); i++) {
            if(prefixNode.childs.containsKey(contact.charAt(i))){
                prefixNode = prefixNode.childs.get(contact.charAt(i));
                contactPath.add(prefixNode);
            }
            else {
                sufixIndex = i;
                break;
            }
        }
        for (int i = sufixIndex; i < contact.length(); i++) {
            Trie trie = new Trie(contact.charAt(i));
            prefixNode.childs.put(contact.charAt(i), trie);
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
            if(!prefixNode.childs.containsKey(prefix.charAt(suffix))){
                return 0;
            }
            prefixNode = prefixNode.childs.get(prefix.charAt(suffix++));
        }
        if(suffix == prefix.length()){
            return prefixNode.isCompleteWord ? prefixNode.words + 1 : prefixNode.words;
        }
        return 0;
    }
}