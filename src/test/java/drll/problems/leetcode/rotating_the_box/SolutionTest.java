package drll.problems.leetcode.rotating_the_box;

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
        assertThat(solution.rotateTheBox(new char[][]{
                {'#', '.', '#'}
        })).isEqualTo(new char[][]{
                {'.'},
                {'#'},
                {'#'}
        });
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.rotateTheBox(new char[][]{
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        })).isEqualTo(new char[][]{
                {'#', '.'},
                {'#', '#'},
                {'*', '*'},
                {'.', '.'}
        });
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.rotateTheBox(new char[][]{
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}
        })).isEqualTo(new char[][]{
                {'.', '#', '#'},
                {'.', '#', '#'},
                {'#', '#', '*'},
                {'#', '*', '.'},
                {'#', '.', '*'},
                {'#', '.', '.'}
        });
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.rotateTheBox(new char[][]{
                {'*', '#', '*', '.', '.', '.', '#', '.', '*', '.'}
        })).isEqualTo(new char[][]{
                {'*'},
                {'#'},
                {'*'},
                {'.'},
                {'.'},
                {'.'},
                {'.'},
                {'#'},
                {'*'},
                {'.'}
        });
    }
}