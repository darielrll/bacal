
package drll.problems.hacker_rank.insertion_sort_advanced_analysis;

import drll.data_structures.avl.AVLNode;
import drll.data_structures.avl.AVLTree;
import drll.data_structures.avl.AVLTreeListener;

public class AVLTreeInsertionAnalysis extends AVLTree<InsertionAnalysis> {

    private long shifts;

    public AVLTreeInsertionAnalysis() {
        setListener(new AVLTreeListener<>() {

            @Override
            public void equalValueDetected(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
                node.getValue().twins++;
                AVLNode<InsertionAnalysis> nodeRight = node.getRight();
                shifts += calculateSide(nodeRight);
            }

            @Override
            public void preInsertingInLeftSide(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
                node.getValue().familyCount++;
                shifts += 1 + node.getValue().twins + calculateSide(node.getRight());
            }

            @Override
            public void preInsertingInRightSide(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
                node.getValue().familyCount++;
            }

            @Override
            public void preRotateRight(AVLNode<InsertionAnalysis> primary) {
                // update family count for node base of rotation
                primary.getValue().familyCount =
                        calculateFamilyCount(primary.getRight(), primary.getLeft().getRight());

                // update family count for future root node
                primary.getLeft().getValue().familyCount =
                        calculateFamilyCount(primary, primary.getLeft().getLeft());
            }

            @Override
            public void preRotateLeft(AVLNode<InsertionAnalysis> primary) {
                // update family count for node base of rotation
                primary.getValue().familyCount =
                        calculateFamilyCount(primary.getLeft(), primary.getRight().getLeft());

                // update family count for future root node
                primary.getRight().getValue().familyCount =
                        calculateFamilyCount(primary, primary.getRight().getRight());
            }
        });
    }

    public int calculateFamilyCount(AVLNode<InsertionAnalysis> sideOne, AVLNode<InsertionAnalysis> sideTwo) {
        return calculateSide(sideOne) + calculateSide(sideTwo);
    }

    public int calculateSide(AVLNode<InsertionAnalysis> node){
        int result = 0;
        if( node != null) {
            result = 1 + node.getValue().familyCount
                    + node.getValue().twins;
        }
        return result;
    }

    public long getShifts() {
        return shifts;
    }
}