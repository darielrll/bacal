package drll.dataStructures.Heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    @Test
    void should_create_a_heap(){
        Heap heap = new Heap();

        assertThat(heap).isNotNull();
    }

    @Test
    void should_count_equal_zero_when_heap_is_created(){
        Heap heap = new Heap();

        assertThat(heap.count()).isZero();
    }
}