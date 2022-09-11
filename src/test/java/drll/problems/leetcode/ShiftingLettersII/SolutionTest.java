package drll.problems.leetcode.ShiftingLettersII;

import org.junit.jupiter.api.BeforeEach;
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
        assertThat(solution.shiftingLetters("abc", new int[][]{
                {0,1,0},
                {1,2,1},
                {0,2,1}
        })).isEqualTo("ace");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.shiftingLetters("dztz", new int[][]{
                {0,0,0},
                {1,1,1}
        })).isEqualTo("catz");
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.shiftingLetters("xuwdbdqik", new int[][]{
                {4,8,0},
                {4,4,0},
                {2,4,0},
                {2,4,0},
                {6,7,1},
                {2,2,1},
                {0,2,1},
                {8,8,0},
                {1,3,1}
        })).isEqualTo("ywxcxcqii");
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.shiftingLetters("viuoyxsaqyhbkuojfwwfpote", new int[][]{
                {10,13,0},{15,18,0},{4,12,1},{0,10,1},{14,14,0},{7,11,1},{18,23,0},{7,22,0},
                {2,8,0},{19,19,0},{13,16,0},{16,20,1},{16,20,0},{10,13,0},{19,21,0},{13,13,0},
                {4,14,0},{13,18,1},{0,11,1},{21,23,0},{10,20,0},{5,9,0},{14,18,1},{19,20,0},
                {6,22,0},{9,14,0},{16,19,1},{23,23,0},{11,18,0},{10,10,0},{22,22,0},{5,7,1},
                {16,19,0},{14,14,0},{23,23,1},{22,23,0},{3,23,1},{7,17,1},{7,15,1},{11,13,0},
                {8,13,1},{7,10,0},{9,22,0},{13,22,1},{19,21,0},{17,19,1},{17,17,0},{14,15,0},
                {19,22,1},{0,20,0},{9,11,1},{18,22,0},{6,22,0},{7,16,0},{4,14,0},{4,16,0},
                {22,23,1},{5,7,0},{15,16,1},{22,23,0},{10,22,1},{19,23,1},{15,16,1},{17,18,0},
                {13,14,1},{16,17,1},{21,23,0},{2,14,1},{5,23,1}
        })).isEqualTo("wjvqyxqypxexdnihevsakkpd");
    }
}