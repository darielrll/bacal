package drll.problems.hackerRank.gameOfThronesI;

import drll.problems.hackerRank.connectedCellsInAGrid.ConnectedCellsInAGrid;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesITest {
    @Test
    void should_rearrenged_as_a_palindrome_example_1(){
        assertThat(GameOfThronesI.gameOfThrones("aabbccdd")).isEqualTo("YES");
    }

    @Test
    void should_rearrenged_as_a_palindrome_example_2(){
        assertThat(GameOfThronesI.gameOfThrones("aaabbbb")).isEqualTo("YES");
    }

    @Test
    void should_not_rearrenged_as_a_palindrome_example_3(){
        assertThat(GameOfThronesI.gameOfThrones("cdefghmnopqrstuvw")).isEqualTo("NO");
    }

    @Test
    void should_rearrenged_as_a_palindrome_example_4(){
        assertThat(GameOfThronesI.gameOfThrones("cdcdcdcdeeeef")).isEqualTo("YES");
    }
}