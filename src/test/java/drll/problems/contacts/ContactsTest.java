
package drll.problems.contacts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactsTest {

    private Trie trie;

    @Before
    public void init(){
        trie = new Trie();
    }

    @Test
    public void should_work_for_test_case1(){
        Integer[] contacts = Contacts.contacts(buildTestCase1());

        assertThat(contacts).containsExactly(2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_ilegal_argument_exception_for_bad_command(){
        Contacts.contacts(buildTestCase2());
    }

    private String[][] buildTestCase1() {
        return new String[][]{
                {"add", "hack"},
                {"add", "hackerrank"},
                {"find", "hac"},
                {"find", "hak"}
        };

    }

    private String[][] buildTestCase2() {
        return new String[][]{
                {"add", "hack"},
                {"add", "hackerrank"},
                {"badCommand", "hac"}
        };

    }
}