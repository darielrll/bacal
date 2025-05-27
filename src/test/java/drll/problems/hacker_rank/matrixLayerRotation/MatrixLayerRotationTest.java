
package drll.problems.hacker_rank.matrixLayerRotation;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MatrixLayerRotationTest {

    @Test
    void should_rotate_ones_for_simple_case() {

        int[][] matrix = buildSimpleCase();

        MatrixLayerRotation.matrixRotation(matrix, 1);

        assertThat(matrix).isEqualTo(buildSimpleCaseAnswer());
    }

    @Test
    void should_rotate_ones_for_3_rotations_in_simple_case() {

        int[][] matrix = buildSimpleCase();

        MatrixLayerRotation.matrixRotation(matrix, 3);

        assertThat(matrix).isEqualTo(buildSimpleCaseAnswerFor3Rotations());
    }

    @Test
    void should_be_the_same_simple_case_for_4_rotations() {

        int[][] matrix = buildSimpleCase();

        MatrixLayerRotation.matrixRotation(matrix, 4);

        assertThat(matrix).isEqualTo(buildSimpleCase());
    }

    @Test
    void should_rotate_twice_for_simple_case_2() {

        int[][] matrix = buildSimpleCase2();

        MatrixLayerRotation.matrixRotation(matrix, 2);

        assertThat(matrix).isEqualTo(buildSimpleCaseAnswer2For2Rotations());
    }

    @Test
    void should_rotate_3_for_simple_case_3() {

        int[][] matrix = buildSimpleCase2();

        MatrixLayerRotation.matrixRotation(matrix, 3);

        assertThat(matrix).isEqualTo(buildSimpleCaseAnswer2For3Rotations());
    }

    @Test
    void should_rotate_for_hacker_rank_test_case_1() {

        int[][] matrix = buildHackerRankCase1();

        MatrixLayerRotation.matrixRotation(matrix, 1);

        assertThat(matrix).isEqualTo(buildHackerRankCase1Answer());
    }

    @Test
    void should_rotate_for_hacker_rank_test_case_2() {

        int[][] matrix = buildHackerRankCase2();

        MatrixLayerRotation.matrixRotation(matrix, 2);

        assertThat(matrix).isEqualTo(buildHackerRankCase2Answer());
    }

    private int[][] buildHackerRankCase1(){
        return new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
    }

    private int[][] buildHackerRankCase1Answer(){
        return new int[][]{{2, 3, 4, 8},
                {1, 7, 11, 12},
                {5, 6, 10, 16},
                {9, 13, 14, 15}};
    }

    private int[][] buildHackerRankCase2(){
        return new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
    }

    private int[][] buildHackerRankCase2Answer(){
        return new int[][]{{3, 4, 8, 12},
                            {2, 11, 10, 16},
                            {1, 7, 6, 15},
                            {5, 9, 13, 14}};
    }

    private int[][] buildSimpleCase(){
        return new int[][]{{1, 2},{3, 4}};
    }

    private int[][] buildSimpleCaseAnswer(){
        return new int[][]{{2, 4},{1, 3}};
    }

    private int[][] buildSimpleCaseAnswerFor3Rotations(){
        return new int[][]{{3, 1},{4, 2}};
    }

    private int[][] buildSimpleCase2(){
        return new int[][]{{1, 2, 3, 4},
                          {1, 2, 3, 4},
                          {1, 2, 3, 4},
                          {1, 2, 3, 4}};
    }

    private int[][] buildSimpleCaseAnswer2For2Rotations(){
        return new int[][]{{3, 4, 4, 4},
                          {2, 3, 2, 4},
                          {1, 3, 2, 3},
                          {1, 1, 1, 2}};
    }

    private int[][] buildSimpleCaseAnswer2For3Rotations(){
        return new int[][]{{4, 4, 4, 4},
                          {3, 2, 2, 3},
                          {2, 3, 3, 2},
                          {1, 1, 1, 1}};
    }
}