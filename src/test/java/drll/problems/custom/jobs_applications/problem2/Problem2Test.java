package drll.problems.custom.jobs_applications.problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @Test
    void should_return_correctly_for_test_case1() {
        List<String> discounts = new ArrayList<>();
        discounts.add("abba");
        discounts.add("abca");

        List<Integer> validation = new ArrayList<>();
        validation.add(1);
        validation.add(0);

        assertThat(Problem2.findValidDiscountCoupons(discounts))
                .isEqualTo(validation);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        List<String> discounts = new ArrayList<>();
        discounts.add("daabbd");
        discounts.add("abc");

        List<Integer> validation = new ArrayList<>();
        validation.add(1);
        validation.add(0);

        assertThat(Problem2.findValidDiscountCoupons(discounts))
                .isEqualTo(validation);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        List<String> discounts = new ArrayList<>();
        discounts.add("acac");

        List<Integer> validation = new ArrayList<>();
        validation.add(0);

        assertThat(Problem2.findValidDiscountCoupons(discounts))
                .isEqualTo(validation);
    }
}