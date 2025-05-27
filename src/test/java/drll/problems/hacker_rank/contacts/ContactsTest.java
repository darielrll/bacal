
package drll.problems.hacker_rank.contacts;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactsTest {

    @Test
    void should_work_for_test_case1(){
        Integer[] contacts = Contacts.contacts(buildTestCase1());

        assertThat(contacts).containsExactly(2, 0);
    }

    @Test()
    void should_throw_illegal_argument_exception_for_bad_command(){
        assertThrows(IllegalArgumentException.class, () -> Contacts.contacts(buildTestCase2()));
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