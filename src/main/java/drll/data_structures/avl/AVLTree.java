
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
        State stateBeforeAdd = recordStateAfterAdd(node.getRight());
        node.setRight(add(node.getRight(), element));
        if(isBalancedSubTree(stateBeforeAdd, node.getRight())){
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
                    node = rotateComplexToASide(node, false);
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
        State stateBeforeAdd = recordStateAfterAdd(node.getLeft());
        node.setLeft(add(node.getLeft(), element));
        if(isBalancedSubTree(stateBeforeAdd, node.getLeft())){
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
                    node = rotateComplexToASide(node, true);
                }
                break;
        }
        return node;
    }

    private State recordStateAfterAdd(AVLNode<T> node) {
        return new State(node == null ? null
                : node.getBalanceFactor());
    }

    private boolean isBalancedSubTree(State stateBeforeAdd, AVLNode<T> node){
        if(stateBeforeAdd.balanceFactor == null){
            // means that a leaf was added
            return false;
        }
        if(stateBeforeAdd.balanceFactor.equals(node.getBalanceFactor())){
            // means that the subtree do not suffer variations in height
            return true;
        }
        // means that the subtree suffer variations in height but now is balanced
        return node.getBalanceFactor().equals(BALANCED);
        // means that the subtree suffer variations in height and the father
        // subtree needs to be balanced
    }

    private boolean isBalancedSubTree(BalanceFactor balanceFactorBeforeAdd, AVLNode<T> node){
        if(balanceFactorBeforeAdd == null){
            // means that a leaf was added
            return false;
        }
        if(balanceFactorBeforeAdd.equals(node.getBalanceFactor())){
            // means that the subtree do not suffer variations in height
            return true;
        }
        // means that the subtree suffer variations in height but now is balanced
        return node.getBalanceFactor().equals(BALANCED);
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

    private AVLNode<T> rotateComplexToASide(AVLNode<T> node, boolean toRightSide){
        BalanceFactor keyBalanceFactor = toRightSide ? node.getLeft().getRight().getBalanceFactor()
                                                    : node.getRight().getLeft().getBalanceFactor();

        if (toRightSide){
            node.setLeft(rotateLeft(node.getLeft()));
            node = rotateRight(node);
        }
        else{
            node.setRight(rotateRight(node.getRight()));
            node = rotateLeft(node);
        }

        if(POSITIVE.equals(keyBalanceFactor)){
            node.getLeft().setBalanceFactor(NEGATIVE);
        }
        else if(NEGATIVE.equals(keyBalanceFactor)){
            node.getRight().setBalanceFactor(POSITIVE);
        }

        return node;
    }

    static class State{
        final BalanceFactor balanceFactor;

        public State(BalanceFactor bfBeforeAdd) {
            this.balanceFactor = bfBeforeAdd;
        }
    }
}