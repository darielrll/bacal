
package drll.problems.hacker_rank.new_year_chaos;

import drll.data_structures.avl.AVLNode;
import drll.data_structures.avl.AVLTree;
import drll.data_structures.avl.AVLTreeListener;

class AVLExtended extends AVLTree<AVLNodeExtended> {

    private int bribes;

    public AVLExtended() {
        setListener(new AVLTreeListener<>() {

            @Override
            public void preInsertingInLeftSide(AVLNode<AVLNodeExtended> node, AVLNodeExtended element) {
                node.getValue().familyCount++;

                int primaryRight = node.getRight() == null
                        ? 0
                        : 1 + node.getRight().getValue().familyCount;

                bribes += 1 + primaryRight;
            }

            @Override
            public void preInsertingInRightSide(AVLNode<AVLNodeExtended> node, AVLNodeExtended element) {
                node.getValue().familyCount++;
            }

            @Override
            public void preRotateRight(AVLNode<AVLNodeExtended> primary) {
                // update family count for node base of rotation
                int primaryRight = primary.getRight() == null
                        ? 0
                        : 1 + primary.getRight().getValue().familyCount;
                int primaryLeft = primary.getLeft().getRight() == null
                        ? 0
                        : 1 + primary.getLeft().getRight().getValue().familyCount;
                primary.getValue().familyCount = primaryRight + primaryLeft;

                // update family count for future root node
                int secondaryRight = 1 + primary.getValue().familyCount;
                int secondaryLeft = primary.getLeft().getLeft() == null
                        ? 0
                        : 1 + primary.getLeft().getLeft().getValue().familyCount;
                primary.getLeft().getValue().familyCount = secondaryRight + secondaryLeft;
            }

            @Override
            public void preRotateLeft(AVLNode<AVLNodeExtended> primary) {
                // update family count for node base of rotation
                int primaryLeft = primary.getLeft() == null
                        ? 0
                        : 1 + primary.getLeft().getValue().familyCount;
                int primaryRight = primary.getRight().getLeft() == null
                        ? 0
                        : 1 + primary.getRight().getLeft().getValue().familyCount;
                primary.getValue().familyCount = primaryLeft + primaryRight;

                // update family count for future root node
                int secondaryLeft = 1 + primary.getValue().familyCount;
                int secondaryRight = primary.getRight().getRight() == null
                        ? 0
                        : 1 + primary.getRight().getRight().getValue().familyCount;
                primary.getRight().getValue().familyCount = secondaryRight + secondaryLeft;
            }
        });
    }

    public int getBribes() {
        return bribes;
    }
}