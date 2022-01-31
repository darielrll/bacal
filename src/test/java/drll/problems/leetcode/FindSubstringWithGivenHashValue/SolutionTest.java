package drll.problems.leetcode.FindSubstringWithGivenHashValue;

import drll.problems.leetcode.FindSubstringWithGivenHashValue.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.subStrHash("leetcode", 7, 20, 2, 0))
                .isEqualTo("ee");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.subStrHash("fbxzaad", 31, 100, 3, 32))
                .isEqualTo("fbx");
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.subStrHash("xmmhdakfursinye", 96, 45, 15, 21))
                .isEqualTo("xmmhdakfursinye");
    }

    @Test
    @Disabled
    void should_return_correctly_for_test_case4() {
        assertThat(solution.subStrHash("xqgfatvtlwnnkxipmipcpqwbxihxblaplpfckvxtihonijhtezdnkjmmk", 22, 51, 41, 9))
                .isEqualTo("xqgfatvtlwnnkxipmipcpqwbxihxblaplpfckvxti");
    }
}