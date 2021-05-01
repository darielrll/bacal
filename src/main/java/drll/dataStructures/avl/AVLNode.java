
package drll.dataStructures.avl;

public class AVLNode<T extends Comparable> {

    private T value;
    private BalanceFactor balanceFactor;
    private AVLNode<T> left;
    private AVLNode<T> right;

    public AVLNode(T value) {
        this.value = value;
        balanceFactor = BalanceFactor.BALANCED;
    }

    public T getValue() {
        return value;
    }

    public BalanceFactor getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(BalanceFactor balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }
}