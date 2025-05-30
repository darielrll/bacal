
package drll.data_structures.avl;

import static drll.data_structures.avl.BalanceFactor.*;

public class AVLTree<T extends Comparable<T>> {

    private long count;
    private AVLNode<T> root;
    private AVLTreeListener<T> listener;

    public long getCount() {
        return count;
    }

    public void setListener(AVLTreeListener<T> listener) {
        this.listener = listener;
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public final void add(T element){
        if(element != null){
            root = add(root, element);
        }
    }

    protected AVLNode<T> add(AVLNode<T> node, T element){
        if(node == null){
            count++;
            return new AVLNode<>(element);
        }
        int compared = element.compareTo(node.getValue());
        if(compared == 0){
            if (listener != null)
                listener.equalValueDetected(node, element);
            return node;
        }
        return compared > 0
                ? insertRight(node, element)
                : insertLeft(node, element);
    }

    private AVLNode<T> insertRight(AVLNode<T> node, T element) {
        //---------------------------
        //-- right branch -- ?++,? --
        //---------------------------
        if (listener != null)
            listener.preInsertingInRightSide(node, element);
        BalanceFactor balanceFactorBeforeAdd = node.getRight() == null
                ? null
                : node.getRight().getBalanceFactor();
        node.setRight(add(node.getRight(), element));
        if(isBalancedSubTree(balanceFactorBeforeAdd, node.getRight().getBalanceFactor())){
            return node;
        }
        switch(node.getBalanceFactor()){
            case BALANCED:
                node.setBalanceFactor(POSITIVE);
                break;
            case NEGATIVE:
                node.setBalanceFactor(BALANCED);
                break;
            default:
                BalanceFactor rightBalanceFactor = node.getRight().getBalanceFactor();
                if (POSITIVE.equals(rightBalanceFactor)) {
                    node = rotateLeft(node);
                }
                else if (NEGATIVE.equals(rightBalanceFactor)) {
                    node = rotateLeftComplex(node);
                }
                break;
        }
        return node;
    }

    private AVLNode<T> insertLeft(AVLNode<T> node, T element) {
        //--------------------------
        //-- left branch -- ?--,? --
        //--------------------------
        if (listener != null)
            listener.preInsertingInLeftSide(node, element);
        BalanceFactor balanceFactorBeforeAdd = node.getLeft() == null
                ? null
                : node.getLeft().getBalanceFactor();
        node.setLeft(add(node.getLeft(), element));
        if(isBalancedSubTree(balanceFactorBeforeAdd, node.getLeft().getBalanceFactor())){
            return node;
        }
        switch(node.getBalanceFactor()){
            case BALANCED:
                node.setBalanceFactor(NEGATIVE);
                break;
            case POSITIVE:
                node.setBalanceFactor(BALANCED);
                break;
            default:
                BalanceFactor leftBalanceFactor = node.getLeft().getBalanceFactor();
                if (NEGATIVE.equals(leftBalanceFactor)) {
                    node = rotateRight(node);
                }
                else if (POSITIVE.equals(leftBalanceFactor)) {
                    node = rotateRightComplex(node);
                }
                break;
        }
        return node;
    }

    private boolean isBalancedSubTree(BalanceFactor balanceFactorBeforeAdd, BalanceFactor balanceFactorActual){
        if(balanceFactorBeforeAdd == null){
            // means that a leaf was added
            return false;
        }
        if(balanceFactorBeforeAdd.equals(balanceFactorActual)){
            // means that the subtree do not suffer variations in height
            return true;
        }
        // means that the subtree suffer variations in height but now is balanced
        return BALANCED.equals(balanceFactorActual);
        // means that the subtree suffer variations in height and the father
        // subtree needs to be balanced
    }

    private AVLNode<T> rotateLeft(AVLNode<T> primary) {
        if (listener != null)
            listener.preRotateLeft(primary);

        AVLNode<T> secondary = primary.getRight();
        primary.setRight(secondary.getLeft());
        secondary.setLeft(primary);

        primary.setBalanceFactor(BALANCED);
        secondary.setBalanceFactor(BALANCED);

        return secondary;
    }

    private AVLNode<T> rotateRight(AVLNode<T> primary) {
        if (listener != null)
            listener.preRotateRight(primary);

        AVLNode<T> secondary = primary.getLeft();
        primary.setLeft(secondary.getRight());
        secondary.setRight(primary);

        primary.setBalanceFactor(BALANCED);
        secondary.setBalanceFactor(BALANCED);

        return secondary;
    }

    private AVLNode<T> rotateRightComplex(AVLNode<T> node){
        BalanceFactor pivotBalanceFactor = node.getLeft().getRight().getBalanceFactor();

        node.setLeft(rotateLeft(node.getLeft()));
        node = rotateRight(node);

        adjustBalanceAfterDoubleRotation(node, pivotBalanceFactor);

        return node;
    }

    private AVLNode<T> rotateLeftComplex(AVLNode<T> node){
        BalanceFactor pivotBalanceFactor = node.getRight().getLeft().getBalanceFactor();

        node.setRight(rotateRight(node.getRight()));
        node = rotateLeft(node);

        adjustBalanceAfterDoubleRotation(node, pivotBalanceFactor);

        return node;
    }

    private void adjustBalanceAfterDoubleRotation(AVLNode<T> node, BalanceFactor pivotChildBalance) {
        if(POSITIVE.equals(pivotChildBalance)){
            node.getLeft().setBalanceFactor(NEGATIVE);
        }
        else if(NEGATIVE.equals(pivotChildBalance)){
            node.getRight().setBalanceFactor(POSITIVE);
        }
    }
}