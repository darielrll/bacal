package drll.data_structures.Trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    private Trie trie;

    @BeforeEach
    void init(){
        trie = new Trie();
    }

    @Test
    void should_have_cero_words_a_new_created_trie() {
        assertThat(trie.count()).isEqualTo(0);
    }

    @Test
    void should_add_a_new_word_and_count_is_incremented_in_one() {
        trie.addWord("hello");

        assertThat(trie.count()).isEqualTo(1);
    }

    @Test
    void should_add_a_new_word_and_most_find_it() {
        trie.addWord("hello");

        assertTrue(trie.contains("hello"));
    }
}