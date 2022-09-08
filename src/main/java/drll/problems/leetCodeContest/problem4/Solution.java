package drll.problems.leetCodeContest.problem4;

public class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long[] subSums = buildConsecutiveSums(runningCosts);
        SegmentTree tree = new SegmentTree(chargeTimes);

        int maxConsecutive = 0;
        for (int k = 1; k <= chargeTimes.length - 1; k++) {
            int windowStart = 0;
            int windowEnd = windowStart + k - 1;
            boolean findNextK = false;
            while (windowEnd <= chargeTimes.length - 1){

                int maxCharge = tree.getMax(windowStart, windowEnd);
                long sum = getSubSum(subSums, windowStart, windowEnd);

                long totalCost = maxCharge + k * sum;
                if(totalCost <= budget){
                   maxConsecutive = k;
                   findNextK = true;
                }

                windowStart++;
                windowEnd++;
            }

            if(!findNextK){
                break;
            }
        }


        return maxConsecutive;
    }

    private long getSubSum(long[] subSums, int windowStart, int windowEnd) {
        if(windowStart == windowEnd  &&  windowEnd == 0){
            return subSums[windowEnd];
        }
        if(windowStart == windowEnd  &&  windowEnd > 0){
            return subSums[windowEnd] - subSums[windowStart - 1];
        }
        if(windowStart == 0  &&  windowEnd == subSums.length - 1){
            return subSums[windowEnd];
        }
        if(windowStart == 0){
            return subSums[windowEnd];
        }
        if(windowEnd == subSums.length - 1){
            return subSums[windowEnd] - subSums[windowStart - 1];
        }
        return subSums[windowEnd + 1] - subSums[windowStart - 1] - (subSums[windowEnd + 1] - subSums[windowEnd]);
    }

    private long[] buildConsecutiveSums(int[] numbers){
        long[] subSums = new long[numbers.length];
        subSums[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            subSums[i] = subSums[i - 1] + numbers[i];
        }
        return subSums;
    }
}

class SegmentTree{
    private final SegmentTreeNode[] tree;

    public SegmentTree(int[] numbers) {
        //tree = new SegmentTreeNode[2 * numbers.length ];
        tree = new SegmentTreeNode[numbers.length * 4];
        buildTree(tree, numbers, 1, 0, numbers.length - 1);
    }

    private void buildTree(SegmentTreeNode[] tree, int[] numbers, int nodePosition, int leftMost, int rightMost) {
        if(leftMost == rightMost){
            tree[nodePosition] = new SegmentTreeNode(leftMost, rightMost, numbers[leftMost]);
        }
        else{
            int leftChildPosition = 2 * nodePosition;
            int leftChildRightMost = (leftMost + rightMost) / 2;
            buildTree(tree, numbers, leftChildPosition, leftMost, leftChildRightMost);

            int rightChildPosition = 2 * nodePosition + 1;
            int rightChildLeftMost = (leftMost + rightMost) / 2 + 1;
            buildTree(tree, numbers, rightChildPosition, rightChildLeftMost, rightMost);

            int nodeValue = Math.max(tree[leftChildPosition].max, tree[rightChildPosition].max);
            tree[nodePosition] = new SegmentTreeNode(leftMost, rightMost, nodeValue);
        }
    }

    public int getMax(int i, int j) {
        return getMax(1, i, j);
    }

    private int getMax(int nodePosition, int leftInterval, int rightInterval) {
        if(isNodeRangeSubSetOfInterval(nodePosition, leftInterval, rightInterval)){
            return tree[nodePosition].max;
        }
        if(haveNodeRangeIntersectionWithInterval(nodePosition, leftInterval , rightInterval)){
            return Math.max(
                    getMax(2 * nodePosition, leftInterval, rightInterval),
                    getMax(2 * nodePosition + 1, leftInterval, rightInterval)
            );
        }
        return Integer.MIN_VALUE;
    }

    private boolean haveNodeRangeIntersectionWithInterval(int nodePosition, int leftInterval, int rightInterval) {
        SegmentTreeNode node = tree[nodePosition];
        return (leftInterval <= node.leftMost  &&  node.leftMost <= rightInterval  &&  rightInterval <= node.rightMost)  ||
                (node.leftMost <= leftInterval  &&  leftInterval <= node.rightMost  &&  node.rightMost <= rightInterval)  ||
                (node.leftMost <= leftInterval  &&  rightInterval <= node.rightMost);
    }

    private boolean isNodeRangeSubSetOfInterval(int nodePosition, int leftInterval, int rightInterval) {
        SegmentTreeNode node = tree[nodePosition];
        return leftInterval <= node.leftMost  &&  node.rightMost <= rightInterval;
    }
}
class SegmentTreeNode{
    int leftMost, rightMost;
    int max;

    public SegmentTreeNode(int leftMost, int rightMost, Integer number) {
        this.leftMost = leftMost;
        this.rightMost = rightMost;
        max = number;
    }
}