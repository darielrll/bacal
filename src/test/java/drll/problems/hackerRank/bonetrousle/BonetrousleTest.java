
package drll.problems.hackerRank.bonetrousle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BonetrousleTest {

    @Test
    public void should_respond_correctly_for_test_case_1_of_hr() {
        int sticksToBuy = 12;
        int boxesForSale = 8;
        int numberOfBoxesToBuy = 3;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertAcceptedCombination(sticksToBuy, numberOfBoxesToBuy, bonetrousle);
    }

    @Test
    public void should_respond_correctly_for_test_case_2_of_hr() {
        int sticksToBuy = 10;
        int boxesForSale = 3;
        int numberOfBoxesToBuy = 3;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertNotExistCombination(bonetrousle);
    }

    @Test
    public void should_respond_correctly_for_test_case_3_of_hr() {
        int sticksToBuy = 9;
        int boxesForSale = 10;
        int numberOfBoxesToBuy = 2;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertAcceptedCombination(sticksToBuy, numberOfBoxesToBuy, bonetrousle);
    }

    @Test
    public void should_return_NA_when_buy_7_sticks_in_4_boxes_and_exist_10_boxes() {
        int sticksToBuy = 7;
        int boxesForSale = 10;
        int numberOfBoxesToBuy = 4;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertNotExistCombination(bonetrousle);
    }

    @Test
    public void should_return_accepted_combination_when_buy_10_sticks_in_4_boxes_and_exist_10_boxes() {
        int sticksToBuy = 10;
        int boxesForSale = 10;
        int numberOfBoxesToBuy = 4;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertAcceptedCombination(sticksToBuy, numberOfBoxesToBuy, bonetrousle);
    }

    @Test
    public void should_return_accepted_combination_when_buy_10_sticks_in_2_boxes_and_exist_10_boxes() {
        int sticksToBuy = 10;
        int boxesForSale = 10;
        int numberOfBoxesToBuy = 2;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertAcceptedCombination(sticksToBuy, numberOfBoxesToBuy, bonetrousle);
    }

    @Test
    public void should_return_NA_when_buy_10_sticks_in_1_boxes_and_exist_4_boxes() {
        int sticksToBuy = 10;
        int boxesForSale = 4;
        int numberOfBoxesToBuy = 1;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertNotExistCombination(bonetrousle);
    }

    @Test
    public void should_return_accepted_combination_when_buy_4_sticks_in_1_boxes_and_exist_4_boxes() {
        int sticksToBuy = 4;
        int boxesForSale = 4;
        int numberOfBoxesToBuy = 1;

        long[] bonetrousle = Bonetrousle.bonetrousle(sticksToBuy, boxesForSale, numberOfBoxesToBuy);

        assertAcceptedCombination(sticksToBuy, numberOfBoxesToBuy, bonetrousle);
    }

    private long getBoughtStick(long[] bonetrousle) {
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            boughtStick += bonetrousle[i];
        }
        return boughtStick;
    }

    private void assertAcceptedCombination(int sticksToBuy, int numberOfBoxesToBuy, long[] bonetrousle) {
        assertThat(bonetrousle.length).isEqualTo(numberOfBoxesToBuy);
        assertThat(getBoughtStick(bonetrousle)).isEqualTo(sticksToBuy);
    }

    private void assertNotExistCombination(long[] bonetrousle) {
        assertThat(bonetrousle.length).isEqualTo(1);
        assertThat(bonetrousle[0]).isEqualTo(-1);
    }
}