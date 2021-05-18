
package drll.problems.hackerRank.insertionSortAdvancedAnalysis;

import common.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AVLTreeInsertionAnalysisTest {

    private AVLTreeInsertionAnalysis tree;

    @BeforeEach
    void init(){
        tree = new AVLTreeInsertionAnalysis();
    }

    @Test
    void should_not_have_shifts_if_tree_is_empty(){

        assertThat(tree.getShifts()).isEqualTo(0);
    }

    @Test
    void should_not_have_shifts_for_only_one_element(){

        tree.add(new InsertionAnalysis(1));

        assertThat(tree.getShifts()).isEqualTo(0);
    }

    @Test
    void should_not_have_shifts_for_two_ordered_asc_elements(){

        tree.add(new InsertionAnalysis(1));
        tree.add(new InsertionAnalysis(2));

        assertThat(tree.getShifts()).isEqualTo(0);
    }

    @Test
    void should_have_only_one_shift_for_two_ordered_desc_elements(){

        tree.add(new InsertionAnalysis(2));
        tree.add(new InsertionAnalysis(1));

        assertThat(tree.getShifts()).isEqualTo(1);
    }

    @Test
    void should_have_6_shifts_for_4_ordered_desc_elements(){

        int[] listOrdered = Utils.buildTestCasesForAnOrderedList(false, 4);

        for (int j : listOrdered) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(6);
        assertThat(tree.getRoot().getValue().familyCount).isEqualTo(3);
        assertThat(tree.getRoot().getLeft().getValue().familyCount).isEqualTo(1);
        assertThat(tree.getRoot().getLeft().getLeft().getValue().familyCount).isEqualTo(0);
        assertThat(tree.getRoot().getRight().getValue().familyCount).isEqualTo(0);
    }

    @Test
    void should_have_as_shifts_as_the_summation_of_length_minus_one_for_worst_case(){

        int[] listOrdered = Utils.buildTestCasesForAnOrderedList(false, 10);

        for (int j : listOrdered) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(45);
    }

    @Test
    void should_have_0_shifts_for_4_ordered_asc_elements(){

        int[] listOrdered = Utils.buildTestCasesForAnOrderedList(true, 4);

        for (int j : listOrdered) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(0);
        assertThat(tree.getRoot().getValue().familyCount).isEqualTo(3);
        assertThat(tree.getRoot().getLeft().getValue().familyCount).isEqualTo(0);
        assertThat(tree.getRoot().getRight().getValue().familyCount).isEqualTo(1);
        assertThat(tree.getRoot().getRight().getRight().getValue().familyCount).isEqualTo(0);
    }

    @Test
    void should_return_swap_number_for_test_1_plus_plus_minus() {

        int[] list = {3, 9, 8};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(1);
    }

    @Test
    void should_return_swap_number_for_test_2_minus_minus_plus() {

        int[] list = {9, 5, 8};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(2);
    }

    @Test
    void should_return_swap_number_for_test_3() {

        int[] list = {1, 1, 1, 2, 2};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(0);
    }

    @Test
    void should_return_swap_number_for_test_4() {

        int[] list = {2, 1, 3, 1, 2};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(4);
    }

    @Test
    void should_return_swap_number_for_test_5() {

        int[] list = {5, 3, 9, 8};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(2);
    }

    @Test
    void should_return_swap_number_for_test_6() {

        int[] list = {5, 3, 9, 8, 6};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(4);
    }

    @Test
    void should_return_swap_number_for_test_7() {

        int[] list = {5, 3, 9, 8, 6, 1};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(9);
    }

    @Test
    void should_return_swap_number_for_test_8() {

        int[] list = {5, 3, 9, 8, 6, 1, 2};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(14);
    }

    @Test
    void should_return_swap_number_for_test_9() {

        int[] list = {5, 3, 9, 8, 6, 1, 2, 7};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(16);
    }

    @Test
    void should_return_swap_number_for_test_10() {

        int[] list = {4, 4, 4, 3, 3, 3, 2, 2, 2};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(27);
    }

    @Test
    void should_return_swap_number_for_test_11() {

        int[] list = {5, 5, 5, 5, 10, 10, 10, 10, 8, 8, 8, 8};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(16);
        assertThat(tree.getRoot().getValue().twins).isEqualTo(3);
        assertThat(tree.getRoot().getValue().familyCount).isEqualTo(8);
        assertThat(tree.getRoot().getLeft().getValue().twins).isEqualTo(3);
        assertThat(tree.getRoot().getLeft().getValue().familyCount).isEqualTo(0);
        assertThat(tree.getRoot().getRight().getValue().twins).isEqualTo(3);
        assertThat(tree.getRoot().getRight().getValue().familyCount).isEqualTo(0);

    }

    @Test
    void should_return_swap_number_for_test_12() {

        int[] list = {5, 5, 5, 5, 3, 3, 3, 3, 4, 4, 4, 4};

        for (int j : list) {
            tree.add(new InsertionAnalysis(j));
        }

        assertThat(tree.getShifts()).isEqualTo(32);
        assertThat(tree.getRoot().getValue().twins).isEqualTo(3);
        assertThat(tree.getRoot().getValue().familyCount).isEqualTo(8);
        assertThat(tree.getRoot().getLeft().getValue().twins).isEqualTo(3);
        assertThat(tree.getRoot().getLeft().getValue().familyCount).isEqualTo(0);
        assertThat(tree.getRoot().getRight().getValue().twins).isEqualTo(3);
        assertThat(tree.getRoot().getRight().getValue().familyCount).isEqualTo(0);

    }
}