
package drll.dataStructures.bit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FenwickTreeTest {

    private FenwickTree subject;

    @BeforeEach
    public void init(){
        subject = new FenwickTree(10);
    }

    @Test
    public void should_create_a_new_fenwick_tree(){
        assertThat(subject).isNotNull();
    }

    @Test
    public void size_should_be_0_for_a_new_fenwick_tree(){
        assertThat(subject.getSize()).isEqualTo(10);
    }

    @Test
    public void should_sum_starting_from1_test_case_1(){
        subject.update(1, 2);
        subject.update(2, 3);

        assertThat(subject.sum(1)).isEqualTo(2L);
        assertThat(subject.sum(2)).isEqualTo(5L);
    }

    @Test
    public void should_sum_starting_from1_test_case_2(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);

        assertThat(subject.sum(1)).isEqualTo(2L);
        assertThat(subject.sum(2)).isEqualTo(5L);
        assertThat(subject.sum(3)).isEqualTo(6L);
    }

    @Test
    public void should_sum_starting_from1_test_case_3(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);

        assertThat(subject.sum(1)).isEqualTo(2L);
        assertThat(subject.sum(2)).isEqualTo(5L);
        assertThat(subject.sum(3)).isEqualTo(6L);
        assertThat(subject.sum(4)).isEqualTo(7L);
    }

    @Test
    public void should_sum_starting_from1_test_case_4(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);

        assertThat(subject.sum(1)).isEqualTo(2L);
        assertThat(subject.sum(2)).isEqualTo(5L);
        assertThat(subject.sum(3)).isEqualTo(6L);
        assertThat(subject.sum(4)).isEqualTo(7L);
        assertThat(subject.sum(5)).isEqualTo(12L);
    }

    @Test
    public void should_sum_starting_from1_test_case_5(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);

        assertThat(subject.sum(1)).isEqualTo(2L);
        assertThat(subject.sum(2)).isEqualTo(5L);
        assertThat(subject.sum(3)).isEqualTo(6L);
        assertThat(subject.sum(4)).isEqualTo(7L);
        assertThat(subject.sum(5)).isEqualTo(12L);
        assertThat(subject.sum(6)).isEqualTo(18L);
    }

    @Test
    public void should_sum_starting_from1_test_case_6(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);

        assertThat(subject.sum(1)).isEqualTo(2L);
        assertThat(subject.sum(2)).isEqualTo(5L);
        assertThat(subject.sum(3)).isEqualTo(6L);
        assertThat(subject.sum(4)).isEqualTo(7L);
        assertThat(subject.sum(5)).isEqualTo(12L);
        assertThat(subject.sum(6)).isEqualTo(18L);
        assertThat(subject.sum(7)).isEqualTo(18L);
    }

    @Test
    public void should_sum_starting_from1_test_case_7(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);
        subject.update(8, 1);

        assertThat(subject.sum(1)).isEqualTo(2L);
        assertThat(subject.sum(2)).isEqualTo(5L);
        assertThat(subject.sum(3)).isEqualTo(6L);
        assertThat(subject.sum(4)).isEqualTo(7L);
        assertThat(subject.sum(5)).isEqualTo(12L);
        assertThat(subject.sum(6)).isEqualTo(18L);
        assertThat(subject.sum(7)).isEqualTo(18L);
        assertThat(subject.sum(8)).isEqualTo(19L);
    }

    @Test
    public void should_sum_starting_fromItoJ_test_case_1(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);
        subject.update(8, 1);

        assertThat(subject.sum(1, 3)).isEqualTo(6L);
    }

    @Test
    public void should_sum_starting_fromItoJ_test_case_2(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);
        subject.update(8, 1);

        assertThat(subject.sum(3, 7)).isEqualTo(13L);
    }

    @Test
    public void should_sum_starting_fromItoJ_test_case_3(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);
        subject.update(8, 1);

        assertThat(subject.sum(7, 8)).isEqualTo(1L);
    }

    @Test
    public void should_sum_starting_fromItoJ_test_case_4(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);
        subject.update(8, 1);

        assertThat(subject.sum(6, 6)).isEqualTo(6L);
    }

    @Test
    public void should_sum_starting_fromItoJ_test_case_5(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);
        subject.update(8, 1);
        subject.update(6, 6, 1);

        assertThat(subject.sum(6, 6)).isEqualTo(7L);
    }

    @Test
    public void should_update_first_element(){
        subject.update(1, 5);

        assertThat(subject.sum(1)).isEqualTo(5l);
    }

    @Test
    public void should_update_from_ItoJ_test_case_1(){
        subject.update(1, 2);
        subject.update(2, 3);
        subject.update(3, 1);
        subject.update(4, 1);
        subject.update(5, 5);
        subject.update(6, 6);
        subject.update(7, 0);
        subject.update(8, 1);


        subject.update(3, 5, 1L);

        assertThat(subject.sum(3, 5)).isEqualTo(10l);
    }

    @Test()
    public void should_throw_index_out_of_bound_exception_if_sum_index_is_gt_size(){
        assertThrows(IndexOutOfBoundsException.class, () -> subject.update(11, 5));
    }

    @Test()
    public void should_throw_index_out_of_bound_exception_if_sum_index_is_lt_0(){
        assertThrows(IndexOutOfBoundsException.class, () -> subject.update(-1, 5));
    }

    @Test()
    public void should_throw_index_out_of_bound_exception_if_sum_index_is_et_0(){
        assertThrows(IndexOutOfBoundsException.class, () -> subject.update(0, 5));
    }

    @Test()
    public void should_throw_index_out_of_bound_exception_if_update_index_is_gt_size(){
        assertThrows(IndexOutOfBoundsException.class, () -> subject.update(11, 2));
    }

    @Test()
    public void should_throw_index_out_of_bound_exception_if_update_index_is_lt_0(){
        assertThrows(IndexOutOfBoundsException.class, () -> subject.update(-1, 2));
    }

    @Test()
    public void should_throw_index_out_of_bound_exception_if_update_index_is_et_0(){
        assertThrows(IndexOutOfBoundsException.class, () -> subject.update(0, 2));
    }
}