
package drll.problems.hackerRank.insertionSortAdvancedAnalysis;

import drll.dataStructures.tree.avl.AVLNode;
import drll.dataStructures.tree.avl.AVLTree;

public class AVLTreeInsertionAnalysis extends AVLTree<InsertionAnalysis> {

    private long shifts;

    public long getShifts() {
        return shifts;
    }

    @Override
    protected void equalValueDetected(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
        super.equalValueDetected(node, element);

        node.getValue().twins++;
        if(node.getRight() != null){
            shifts += 1 + node.getRight().getValue().twins +
                    node.getRight().getValue().familyCount;
        }
    }

    @Override
    protected void preInsertingInRightSide(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
        super.preInsertingInRightSide(node, element);

        node.getValue().familyCount++;
    }

    @Override
    protected void preInsertingInLeftSide(AVLNode<InsertionAnalysis> node, InsertionAnalysis element) {
        super.preInsertingInLeftSide(node, element);

        node.getValue().familyCount++;
        if(node.getRight() == null){
            shifts += 1 + node.getValue().twins;
        }
        else{
            shifts += 1 + node.getValue().twins +
                    1 + node.getRight().getValue().twins +
                    node.getRight().getValue().familyCount;
        }
    }

    @Override
    protected void preRotateLeft(AVLNode<InsertionAnalysis> primary) {
        super.preRotateLeft(primary);

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

    @Override
    protected void preRotateRight(AVLNode<InsertionAnalysis> primary) {
        super.preRotateRight(primary);

        // update family count for node base of rotation
        int primaryRight = primary.getRight() == null
                ? 0
                : 1 + primary.getRight().getValue().familyCount
                    + primary.getRight().getValue().twins;
        int primaryLeft = primary.getLeft().getRight() == null
                ? 0
                : 1 + primary.getLeft().getRight().getValue().familyCount
                    + primary.getLeft().getRight().getValue().twins;
        primary.getValue().familyCount = primaryRight + primaryLeft;

        // update family count for future root node
        int secondaryRight = 1 + primary.getValue().familyCount
                                + primary.getValue().twins;
        int secondaryLeft = primary.getLeft().getLeft() == null
                                    ? 0
                                    : 1 + primary.getLeft().getLeft().getValue().familyCount
                                        + primary.getLeft().getLeft().getValue().twins;
        primary.getLeft().getValue().familyCount = secondaryRight + secondaryLeft;
    }
}