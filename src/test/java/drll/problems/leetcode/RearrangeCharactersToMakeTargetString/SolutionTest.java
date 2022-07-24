package drll.problems.leetcode.RearrangeCharactersToMakeTargetString;

import drll.problems.leetcode.RearrangeCharactersToMakeTargetString.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution binarySearch;

    @BeforeEach
    void init(){
        binarySearch = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(binarySearch.rearrangeCharacters("ilovecodingonleetcode", "code"))
                .isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(binarySearch.rearrangeCharacters("abcba", "abc"))
                .isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(binarySearch.rearrangeCharacters("abbaccaddaeea", "aaaaa"))
                .isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(binarySearch.rearrangeCharacters("abc", "abcd"))
                .isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(binarySearch.rearrangeCharacters("zys", "adk"))
                .isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case6() {
        assertThat(binarySearch.rearrangeCharacters("wvu", "tu"))
                .isEqualTo(0);
    }
}