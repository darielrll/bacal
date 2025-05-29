package drll.data_structures.avl;

public interface AVLTreeListener<T extends Comparable<T>> {
    default void equalValueDetected(AVLNode<T> node, T element) {}
    default void preInsertingInLeftSide(AVLNode<T> node, T element) {}
    default void preInsertingInRightSide(AVLNode<T> node, T element) {}
    default void preRotateRight(AVLNode<T> primary) {}
    default void preRotateLeft(AVLNode<T> primary) {}
}
