
package drll.dataStructures.avl;

public class AVLTree<T extends Comparable> {

    private long count;
    private AVLNode<T> root;

    public AVLTree() {}

    public long getCount() {
        return count;
    }

    protected void equalValueDetected(AVLNode<T> node, T element){}
    protected void preInsertingInLeftSide(AVLNode<T> node, T element){}
    protected void preInsertingInRightSide(AVLNode<T> node, T element){}
    protected void preRotateRight(AVLNode<T> primary){}
    protected void preRotateLeft(AVLNode<T> primary){}

    public AVLNode<T> getRoot() {
        return root;
    }

    public final void add(T element){
        if(element != null){
            root = add(root, element);
        }
    }

    protected AVLNode add(AVLNode<T> node, T element){
        if(node == null){
            count++;
            return new AVLNode(element);
        }
        if(element.compareTo(node.getValue()) == 0){
            equalValueDetected(node, element);
            return node;
        }
        //------------------
        //-- right branch -- ?++,?
        //------------------
        if(element.compareTo(node.getValue()) > 0) {
            preInsertingInRightSide(node, element);
            State stateBeforeAdd = recordStateAfterAdd(node.getRight());
            node.setRight(add(node.getRight(), element));
            if(isBalancedSubTree(stateBeforeAdd, node.getRight())){
                return node;
            }
            if (BalanceFactor.BALANCED.equals(node.getBalanceFactor())) {
                node.setBalanceFactor(BalanceFactor.POSITIVE);
            }
            else if (BalanceFactor.NEGATIVE.equals(node.getBalanceFactor())) {
                node.setBalanceFactor(BalanceFactor.BALANCED);
            }
            else if (BalanceFactor.POSITIVE.equals(node.getRight().getBalanceFactor())) {
                node = rotateLeft(node);
            }
            else if (BalanceFactor.NEGATIVE.equals(node.getRight().getBalanceFactor())) {
                node = rotateComplexToASide(node, false);
            }
        }
        //-----------------
        //-- left branch -- ?--,?
        //-----------------
        else {
            preInsertingInLeftSide(node, element);
            State stateBeforeAdd = recordStateAfterAdd(node.getLeft());
            node.setLeft(add(node.getLeft(), element));
            if(isBalancedSubTree(stateBeforeAdd, node.getLeft())){
                return node;
            }
            if (BalanceFactor.BALANCED.equals(node.getBalanceFactor())) {
                node.setBalanceFactor(BalanceFactor.NEGATIVE);
            }
            else if (BalanceFactor.POSITIVE.equals(node.getBalanceFactor())) {
                node.setBalanceFactor(BalanceFactor.BALANCED);
            }
            else if (BalanceFactor.NEGATIVE.equals(node.getLeft().getBalanceFactor())) {
                node = rotateRight(node);
            }
            else if (BalanceFactor.POSITIVE.equals(node.getLeft().getBalanceFactor())) {
                node = rotateComplexToASide(node, true);
            }
        }
        return node;
    }

    private State recordStateAfterAdd(AVLNode<T> node) {
        return new State(node == null ? null
                : node.getBalanceFactor());
    }

    private boolean isBalancedSubTree(State stateBeforeAdd, AVLNode node){
        if(stateBeforeAdd.balanceFactor == null){
            // means that a leaf was added
            return false;
        }
        if(stateBeforeAdd.balanceFactor.equals(node.getBalanceFactor())){
            // means that the subtree do not suffer variations in height
            return true;
        }
        // means that the subtree suffer variations in height but now is balanced
        return node.getBalanceFactor().equals(BalanceFactor.BALANCED);
        // means that the subtree suffer variations in height and the father
        // subtree needs to be balanced
    }

    private AVLNode<T> rotateLeft(AVLNode<T> primary) {
        preRotateLeft(primary);

        AVLNode<T> secondary = primary.getRight();
        primary.setRight(secondary.getLeft());
        secondary.setLeft(primary);

        primary.setBalanceFactor(BalanceFactor.BALANCED);
        secondary.setBalanceFactor(BalanceFactor.BALANCED);

        return secondary;
    }

    private AVLNode<T> rotateRight(AVLNode<T> primary) {
        preRotateRight(primary);

        AVLNode<T> secondary = primary.getLeft();
        primary.setLeft(secondary.getRight());
        secondary.setRight(primary);

        primary.setBalanceFactor(BalanceFactor.BALANCED);
        secondary.setBalanceFactor(BalanceFactor.BALANCED);

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

        if(BalanceFactor.POSITIVE.equals(keyBalanceFactor)){
            node.getLeft().setBalanceFactor(BalanceFactor.NEGATIVE);
        }
        else if(BalanceFactor.NEGATIVE.equals(keyBalanceFactor)){
            node.getRight().setBalanceFactor(BalanceFactor.POSITIVE);
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