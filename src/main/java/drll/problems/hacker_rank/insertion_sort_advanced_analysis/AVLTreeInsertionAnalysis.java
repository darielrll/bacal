
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
                if(nodeRight == null) return;
                shifts += 1 + nodeRight.getValue().twins +
                        nodeRight.getValue().familyCount;
            }

            @Override
            public void preInsertingInLeftSide(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
                node.getValue().familyCount++;
                shifts += 1 + node.getValue().twins;
                if(node.getRight() != null){
                    shifts += 1 + node.getRight().getValue().twins +
                            node.getRight().getValue().familyCount;
                }
            }

            @Override
            public void preInsertingInRightSide(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
                node.getValue().familyCount++;
            }

            @Override
            public void preRotateRight(AVLNode<InsertionAnalysis> primary) {
                // update family count for node base of rotation
                int primaryRight = 0;
                AVLNode<InsertionAnalysis> right = primary.getRight();
                if( right != null) {
                    primaryRight = 1 + right.getValue().familyCount
                                     + right.getValue().twins;
                }

                int primaryLeft = 0;
                AVLNode<InsertionAnalysis> leftSubtreeRightChild = primary.getLeft().getRight();
                if(leftSubtreeRightChild != null){
                    primaryLeft = 1 + leftSubtreeRightChild.getValue().familyCount
                                    + leftSubtreeRightChild.getValue().twins;
                }

                primary.getValue().familyCount = primaryRight + primaryLeft;

                // update family count for future root node
                int secondaryRight = 1 + primary.getValue().familyCount
                                       + primary.getValue().twins;
                int secondaryLeft = 0;
                AVLNode<InsertionAnalysis> leftSubtreeLeftChild = primary.getLeft().getLeft();
                if(leftSubtreeLeftChild != null) {
                    secondaryLeft =  1 + leftSubtreeLeftChild.getValue().familyCount
                                       + leftSubtreeLeftChild.getValue().twins;
                }
                primary.getLeft().getValue().familyCount = secondaryRight + secondaryLeft;
            }

            @Override
            public void preRotateLeft(AVLNode<InsertionAnalysis> primary) {
                // update family count for node base of rotation
                int primaryLeft = primary.getLeft() == null
                        ? 0
                        : 1 + primary.getLeft().getValue().familyCount
                        + primary.getLeft().getValue().twins;
                int primaryRight = primary.getRight().getLeft() == null
                        ? 0
                        : 1 + primary.getRight().getLeft().getValue().familyCount
                        + primary.getRight().getLeft().getValue().twins;
                primary.getValue().familyCount = primaryLeft + primaryRight;

                // update family count for future root node
                int secondaryLeft = 1 + primary.getValue().familyCount
                        + primary.getValue().twins;
                int secondaryRight = primary.getRight().getRight() == null
                        ? 0
                        : 1 + primary.getRight().getRight().getValue().familyCount
                        + primary.getRight().getRight().getValue().twins;
                primary.getRight().getValue().familyCount = secondaryRight + secondaryLeft;
            }
        });
    }

    public long getShifts() {
        return shifts;
    }
}