
package drll.dataStructures.tree.avl;

import static org.assertj.core.api.Assertions.*;

import common.Utils;
import drll.dataStructures.tree.avl.AVLNode;
import drll.dataStructures.tree.avl.AVLTree;
import drll.dataStructures.tree.avl.BalanceFactor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AVLTreeTest {

    private AVLTree<Integer> tree;

    @Before
    public void init(){
        tree = new AVLTree<>();
    }

    @Test
    public void should_not_add_null_values(){

        tree = new AVLTree<>();
        tree.add(3);

        tree.add(null);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(3);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getLeft()).isNull();
        assertThat(tree.getRoot().getRight()).isNull();
        assertThat(tree.getCount()).isEqualTo(1);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_function_adding_only_one_element() {

        int element = 5;

        tree.add(element);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(element);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getCount()).isEqualTo(1);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_not_add_equal_values(){
        int root = 5;

        tree.add(root);
        tree.add(root);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(root);
        assertThat(tree.getRoot().getRight()).isNull();
        assertThat(tree.getRoot().getLeft()).isNull();
        assertThat(tree.getCount()).isEqualTo(1);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_add_minor_value_to_the_left(){
        int rootElement = 5;
        int lessElement = 3;

        tree.add(rootElement);

        tree.add(lessElement);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(rootElement);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(lessElement);
        assertThat(tree.getRoot().getRight()).isNull();
        assertThat(tree.getCount()).isEqualTo(2);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_add_mayor_value_to_the_right(){
        int rootElement = 5;
        int greaterElement = 8;

        tree.add(rootElement);

        tree.add(greaterElement);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(rootElement);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(greaterElement);
        assertThat(tree.getRoot().getLeft()).isNull();
        assertThat(tree.getCount()).isEqualTo(2);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void balance_factor_should_be_negative_after_add_minor_value(){
        int rootElement = 5;
        int lessElement = 3;

        tree.add(rootElement);

        tree.add(lessElement);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.NEGATIVE);
        assertThat(tree.getCount()).isEqualTo(2);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void balance_factor_should_be_positive_after_add_mayor_value(){
        int rootElement = 5;
        int greaterElement = 8;

        tree.add(rootElement);

        tree.add(greaterElement);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.POSITIVE);
        assertThat(tree.getCount()).isEqualTo(2);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void balance_factor_should_be_balanced_after_add_minor_and_mayor_value(){
        int rootElement = 5;
        int mayorElement = 8;
        int minorElement = 3;

        tree.add(rootElement);
        tree.add(minorElement);
        tree.add(mayorElement);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(rootElement);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(minorElement);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(mayorElement);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_not_add_an_existing_mayor_value_after_add_minor_and_mayor_value(){

        int rootElement = 5;
        int mayorElement = 8;
        int minorElement = 3;

        tree.add(rootElement);
        tree.add(minorElement);
        tree.add(mayorElement);

        tree.add(mayorElement);

        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getRight().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);

        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_not_add_an_existing_minor_value_after_add_minor_and_mayor_value(){

        int rootElement = 5;
        int mayorElement = 8;
        int minorElement = 3;

        tree.add(rootElement);
        tree.add(minorElement);
        tree.add(mayorElement);

        tree.add(minorElement);

        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getLeft().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);

        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_properties_after_height_is_mayor_than_1_adding_a_less_value(){

        int minorValue = 1;
        int root = 5;
        int left = 3;
        int right = 8;

        tree = new AVLTree<>();
        tree.add(root);
        tree.add(right);
        tree.add(left);

        tree.add(minorValue);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(root);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(right);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(left);
        assertThat(tree.getRoot().getLeft().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getLeft().getValue()).isEqualTo(minorValue);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.NEGATIVE);
        assertThat(tree.getCount()).isEqualTo(4);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_properties_after_height_is_mayor_than_1_adding_a_mayor_value(){

        int mayorValue = 10;
        int root = 5;
        int left = 3;
        int right = 8;

        tree = new AVLTree<>();
        tree.add(root);
        tree.add(right);
        tree.add(left);

        tree.add(mayorValue);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(root);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(right);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(left);
        assertThat(tree.getRoot().getRight().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getRight().getValue()).isEqualTo(mayorValue);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.POSITIVE);
        assertThat(tree.getCount()).isEqualTo(4);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_avl_property_after_insert_1_5_10(){

        tree.add(1);
        tree.add(5);
        tree.add(10);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(5);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(1);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(10);
        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_update_balance_factor_after_insert_1_5_10(){

        tree.add(1);
        tree.add(5);
        tree.add(10);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getLeft().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_avl_property_after_insert_1_5_10_15_20_25(){

        tree.add(1);
        tree.add(5);
        tree.add(10);
        tree.add(15);
        tree.add(20);
        tree.add(25);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(15);
        assertThat(tree.getCount()).isEqualTo(6);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_avl_property_after_insert_1_5_10_15_7(){

        tree.add(1);
        tree.add(5);
        tree.add(10);
        tree.add(15);
        tree.add(7);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(5);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.POSITIVE);
        assertThat(tree.getCount()).isEqualTo(5);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_avl_property_after_insert_10_5_1(){

        tree.add(10);
        tree.add(5);
        tree.add(1);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(5);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(1);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(10);
        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_update_balance_factor_after_insert_10_5_1(){

        tree.add(10);
        tree.add(5);
        tree.add(1);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getLeft().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_avl_property_after_insert_25_20_15_10_5_1(){

        tree.add(25);
        tree.add(20);
        tree.add(15);
        tree.add(10);
        tree.add(5);
        tree.add(1);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(10);
        assertThat(tree.getCount()).isEqualTo(6);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_maintain_avl_property_after_insert_15_10_5_1_7(){

        tree.add(15);
        tree.add(10);
        tree.add(5);
        tree.add(1);
        tree.add(7);

        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getValue()).isEqualTo(10);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.NEGATIVE);
        assertThat(tree.getCount()).isEqualTo(5);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_5_9_7(){

        tree.add(5);
        tree.add(9);
        tree.add(7);

        assertThat(tree.getRoot().getValue()).isEqualTo(7);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(5);
        assertThat(tree.getRoot().getLeft().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(9);
        assertThat(tree.getRoot().getRight().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_9_5_7(){

        tree.add(9);
        tree.add(5);
        tree.add(7);

        assertThat(tree.getRoot().getValue()).isEqualTo(7);
        assertThat(tree.getRoot().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getLeft().getValue()).isEqualTo(5);
        assertThat(tree.getRoot().getLeft().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getRoot().getRight().getValue()).isEqualTo(9);
        assertThat(tree.getRoot().getRight().getBalanceFactor()).isEqualTo(BalanceFactor.BALANCED);
        assertThat(tree.getCount()).isEqualTo(3);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_from_1_to_10(){
        int[] list = Utils.buildTestCasesForAnOrderedList(true, 10);

        for(int i = 0; i < list.length; i++){
            tree.add(list[i]);
        }

        assertThat(tree.getCount()).isEqualTo(10);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_from_1_to_100(){
        int[] list = Utils.buildTestCasesForAnOrderedList(true, 100);

        for(int i = 0; i < list.length; i++){
            tree.add(list[i]);
        }

        assertThat(tree.getCount()).isEqualTo(100);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_from_10_to_1(){
        int[] list = Utils.buildTestCasesForAnOrderedList(false, 10);

        for(int i = 0; i < list.length; i++){
            tree.add(list[i]);
        }

        assertThat(tree.getCount()).isEqualTo(10);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_from_100_to_1(){
        int[] list = Utils.buildTestCasesForAnOrderedList(true, 100);

        for(int i = 0; i < list.length; i++){
            tree.add(list[i]);
        }

        assertThat(tree.getCount()).isEqualTo(100);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_two_same_ordered_list_in_reverse_order_merged(){
        int[] orderedAscList = Utils.buildTestCasesForAnOrderedList(true, 100);
        int[] orderedDescList = Utils.buildTestCasesForAnOrderedList(false, 100);

        int[] mergedList = Utils.mergeArrays(orderedAscList, orderedDescList);

        for(int i = 0; i < mergedList.length; i++){
            tree.add(mergedList[i]);
        }

        assertThat(tree.getCount()).isEqualTo(orderedAscList.length);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_two_ordered_list_in_reverse_order_merged(){
        int[] orderedAscList = Utils.buildTestCasesForAnOrderedList(true, 100);
        int[] orderedDescList = Utils.buildTestCasesForAnOrderedList(false, 100, 200);

        int[] mergedList = Utils.mergeArrays(orderedAscList, orderedDescList);

        for(int i = 0; i < mergedList.length; i++){
            tree.add(mergedList[i]);
        }

        assertThat(tree.getCount()).isEqualTo(orderedAscList.length + orderedDescList.length);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_1000_random_elements(){
        Integer[] list = Utils.buildTestCasesForARandomList(true, 600, 10000);

        for(int i = 0; i < list.length; i++){
            tree.add(list[i]);
        }

        assertThat(tree.getCount()).isLessThanOrEqualTo(600);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_a_set_of_1000_random_elements(){
        Integer[] list = Utils.buildTestCasesForARandomList(false, 100000, 10000);

        for(int i = 0; i < list.length; i++){
            tree.add(list[i]);
        }

        assertThat(tree.getCount()).isEqualTo(10000);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    @Test
    public void should_be_an_avl_after_add_112_elements(){
        String part1 = "480130 735329 810013 140187 972418 357056 334780 854684 478980 34590 180238 567090 935248 834854 514996 950881 104525 874212 160000 528785 770712 201115 830644 535327 668785 241043 946633 645108 184097 251762 97219 664226 503442 907232 320764 992211 264287 171895 846895 259618 722836 543484 343059 658083 378338 858054 125316 999214 248618 285315 527999 535681 2781 358642 71007 671565 116036 17639 833024 300132 785753 930243 480710 805546 353826 317825 797757 134464 6072 161003 394081 728907 704486 253492 386990 599175 111545 28657 598389 360162 313971 642739 895842 833103 1380 966849 21019 633767 500839 854043 450251 802943 784285 930960 608489 654462 765136 922597 788925 771207 83599 699357 500114 304436 952848 403455 419963 580745 432111 534703 457258 262433";
        int[] numbers = Utils.buildTestCasesForVeryLongEntries(part1);

        for(int i = 0; i < numbers.length; i++){
            tree.add(numbers[i]);
        }

        assertThat(tree.getCount()).isEqualTo(112);
        assertThat(isAVLTree(tree.getRoot())).isTrue();
    }

    private boolean isAVLTree(AVLNode node){

        if (node == null){
            return true;
        }

        int heightRight = getHeight(node.getRight());
        int heightLeft = getHeight(node.getLeft());

        if(Math.abs(heightRight - heightLeft) > 1){
            return false;
        }
        if(node.getLeft() != null  &&  node.getLeft().getValue().compareTo(node.getValue()) > 0){
            return false;
        }
        if(node.getRight() != null  &&  node.getRight().getValue().compareTo(node.getValue()) < 0){
            return false;
        }
        return isAVLTree(node.getRight())  &&  isAVLTree(node.getLeft());
    }

    private int getHeight(AVLNode node){
        if(node == null){
            return 0;
        }
        if(node.getBalanceFactor().equals(BalanceFactor.POSITIVE)){
            return 1 + getHeight(node.getRight());
        }
        return 1 + getHeight(node.getLeft());
    }
}