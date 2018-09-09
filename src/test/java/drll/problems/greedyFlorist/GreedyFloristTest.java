package drll.problems.greedyFlorist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GreedyFloristTest {

    @Test
    public void should_work_for_test_case_1() {
        int[] flowerPrices = {2, 5, 6};
        int minimumCost = GreedyFlorist.getMinimumCost(3, flowerPrices);
        assertEquals(minimumCost, 13);
    }

    @Test
    public void should_work_for_test_case_2() {
        int[] flowerPrices = {2, 5, 6};
        int minimumCost = GreedyFlorist.getMinimumCost(2, flowerPrices);
        assertEquals(minimumCost, 15);
    }

    @Test
    public void should_work_for_test_case_3() {
        int[] flowerPrices = {1, 3, 5, 7, 9};
        int minimumCost = GreedyFlorist.getMinimumCost(3, flowerPrices);
        assertEquals(minimumCost, 29);
    }
}