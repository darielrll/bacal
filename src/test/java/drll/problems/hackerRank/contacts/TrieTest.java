
package drll.problems.hackerRank.contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TrieTest {

    private Trie subject;

    @BeforeEach
    public void init(){
        subject = new Trie();
    }

    @Test
    public void add_should_work_for_test_case1(){
        subject.add("hack");

        int contacts = subject.words;

        assertThat(contacts).isEqualTo(1);
    }

    @Test
    public void add_should_work_for_test_case2(){
        subject.add("hack");
        subject.add("hackerrank");

        int contacts = subject.words;

        assertThat(contacts).isEqualTo(2);
    }

    @Test
    public void add_should_work_for_test_case3(){
        subject.add("s");
        subject.add("ss");

        int contacts = subject.words;

        assertThat(contacts).isEqualTo(2);
    }

    @Test
    public void find_partial_should_work_for_test_case1(){
        subject.add("hack");
        subject.add("hackerrank");

        int contacts = subject.findPartial("hac");

        assertThat(contacts).isEqualTo(2);
    }

    @Test
    public void find_partial_should_work_for_test_case2(){
        subject.add("hack");
        subject.add("hackerrank");

        int contacts = subject.findPartial("hak");

        assertThat(contacts).isEqualTo(0);
    }

    @Test
    public void find_partial_should_work_for_test_case3(){
        subject.add("hack");
        subject.add("hackerrank");

        int contacts = subject.findPartial("noexist");

        assertThat(contacts).isEqualTo(0);
    }

    @Test
    public void find_partial_should_work_for_test_case4(){
        subject.add("s");
        subject.add("ss");
        subject.add("sss");
        subject.add("ssss");
        subject.add("sssss");

        int contacts = subject.findPartial("s");

        assertThat(contacts).isEqualTo(5);
    }

    @Test
    public void find_partial_should_work_for_test_case5(){
        subject.add("s");
        subject.add("ss");
        subject.add("sss");
        subject.add("ssss");
        subject.add("sssss");

        int contacts = subject.findPartial("ss");

        assertThat(contacts).isEqualTo(4);
    }

    @Test
    public void find_partial_should_work_for_test_case6(){
        subject.add("s");
        subject.add("ss");
        subject.add("sss");
        subject.add("ssss");
        subject.add("sssss");

        int contacts = subject.findPartial("sss");

        assertThat(contacts).isEqualTo(3);
    }

    @Test
    public void find_partial_should_work_for_test_case7(){
        subject.add("s");
        subject.add("ss");
        subject.add("sss");
        subject.add("ssss");
        subject.add("sssss");

        int contacts = subject.findPartial("ssss");

        assertThat(contacts).isEqualTo(2);
    }

    @Test
    public void find_partial_should_work_for_test_case8(){
        subject.add("s");
        subject.add("ss");
        subject.add("sss");
        subject.add("ssss");
        subject.add("sssss");

        int contacts = subject.findPartial("sssss");

        assertThat(contacts).isEqualTo(1);
    }

    @Test
    public void find_partial_should_work_for_test_case9(){
        subject.add("s");
        subject.add("ss");
        subject.add("sss");
        subject.add("ssss");
        subject.add("sssss");

        int contacts = subject.findPartial("ssssss");

        assertThat(contacts).isEqualTo(0);
    }

    @Test
    public void find_partial_should_work_for_test_case10(){
        subject.add("s");
        subject.add("ss");

        int contacts = subject.findPartial("sss");

        assertThat(contacts).isEqualTo(0);
    }
}