package drll.problems.leetcode.maximumPointsYouCanObtainFromCards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void should_return_correctly_for_test_case1() {
        assertThat(solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3)).isEqualTo(12);
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        assertThat(solution.maxScore(new int[]{2, 2, 2}, 2)).isEqualTo(4);
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        assertThat(solution.maxScore(new int[]{9,7,7,9,7,7,9}, 7)).isEqualTo(55);
    }

    @Test
    public void should_return_correctly_for_test_case4() {
        assertThat(solution.maxScore(new int[]{1, 1000, 1}, 1)).isEqualTo(1);
    }

    @Test
    public void should_return_correctly_for_test_case5() {
        assertThat(solution.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3)).isEqualTo(202);
    }

    @Test
    public void should_return_correctly_for_test_case6() {
        assertThat(solution.maxScore(new int[]{11, 49, 100, 20, 86, 29, 72}, 4)).isEqualTo(232);
    }

    @Test
    public void should_return_correctly_for_test_case7() {
        assertThat(solution.maxScore(new int[]{
                53, 14, 91, 35, 51, 9, 80, 27, 6, 15, 77, 86, 34,
                62, 55, 45, 91, 45, 23, 75, 66, 42, 62, 13, 34, 18,
                89, 67, 93, 83, 100, 14, 92, 73, 48, 2, 47, 93, 99,
                100, 88, 84, 48}, 43)).isEqualTo(2429);
    }

    @Test
    public void should_return_correctly_for_test_case8() {
        assertThat(solution.maxScore(new int[]{
                61, 5, 22, 64, 14, 16, 93, 28, 7, 99, 8, 17, 2,
                83, 9, 88, 16, 97, 33, 50, 78, 5, 78, 100, 100,
                44, 43, 73, 14, 31, 1, 72, 93, 42, 48, 49, 3,
                26, 59, 8, 20, 39, 40, 67, 27}, 34)).isEqualTo(232);
    }
}