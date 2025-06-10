
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
                //int primaryRight = 0;
                int primaryRight = calculateSide(primary.getRight());
                int primaryLeft = calculateSide(primary.getLeft().getRight());
                primary.getValue().familyCount = primaryRight + primaryLeft;

                // update family count for future root node
                int secondaryRight = calculateSide(primary);
                int secondaryLeft = calculateSide(primary.getLeft().getLeft());
                primary.getLeft().getValue().familyCount = secondaryRight + secondaryLeft;
            }

            @Override
            public void preRotateLeft(AVLNode<InsertionAnalysis> primary) {
                // update family count for node base of rotation
                int primaryLeft = calculateSide(primary.getLeft());
                int primaryRight = calculateSide(primary.getRight().getLeft());
                primary.getValue().familyCount = primaryLeft + primaryRight;

                // update family count for future root node
                int secondaryLeft = calculateSide(primary);
                int secondaryRight = calculateSide(primary.getRight().getRight());
                primary.getRight().getValue().familyCount = secondaryRight + secondaryLeft;
            }
        });
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