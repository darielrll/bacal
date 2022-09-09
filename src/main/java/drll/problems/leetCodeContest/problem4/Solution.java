package drll.problems.leetCodeContest.problem4;

public class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long[] subSums = buildConsecutiveSums(runningCosts);
        SegmentTree tree = new SegmentTree(chargeTimes);

        int maxConsecutive = 0;
        int consecutiveRobots = 1;
        while (consecutiveRobots <= chargeTimes.length) {
            int windowStart = 0;
            boolean findNextK = false;
            while (windowStart + consecutiveRobots <= chargeTimes.length){

                int maxCharge = tree.getMaxQuery(windowStart, windowStart + consecutiveRobots - 1);
                long sum = getSubSum(subSums, windowStart, windowStart + consecutiveRobots - 1);

                long totalCost = maxCharge + consecutiveRobots * sum;
                if(totalCost <= budget){
                   maxConsecutive = consecutiveRobots;
                   findNextK = true;
                   break;
                }
                windowStart++;
            }
            if(!findNextK){
                break;
            }
            consecutiveRobots++;
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
    private final int[] tree;

    public SegmentTree(int[] numbers) {
        tree = new int[numbers.length * 4];
        buildTree(tree, numbers, 1, 0, numbers.length - 1);
    }

    private void buildTree(int[] tree, int[] numbers, int nodePosition, int leftMost, int rightMost) {
        if(leftMost == rightMost){
            tree[nodePosition] = numbers[leftMost];
        }
        else{
            int leftChildPosition = 2 * nodePosition;
            int leftChildRightMost = (leftMost + rightMost) / 2;
            buildTree(tree, numbers, leftChildPosition, leftMost, leftChildRightMost);

            int rightChildPosition = 2 * nodePosition + 1;
            int rightChildLeftMost = (leftMost + rightMost) / 2 + 1;
            buildTree(tree, numbers, rightChildPosition, rightChildLeftMost, rightMost);

            int nodeValue = Math.max(tree[leftChildPosition], tree[rightChildPosition]);
            tree[nodePosition] = nodeValue;
        }
    }

    public int getMaxQuery(int i, int j) {
        return getMaxQuery(1, 0, (tree.length / 4) - 1, i, j);
    }

    private int getMaxQuery(int nodePosition, int nodeLeftMost, int nodeRightMost, int leftInterval, int rightInterval) {
        if(nodeRangeDoNotIntersectInterval(nodeLeftMost, nodeRightMost, leftInterval, rightInterval)){
            return Integer.MIN_VALUE;
        }
        if(isNodeRangeSubSetOfInterval(nodeLeftMost, nodeRightMost, leftInterval, rightInterval)){
            return tree[nodePosition];
        }

        int leftNode = 2 * nodePosition;
        int nodeLeftRightMost = (nodeLeftMost + nodeRightMost) / 2;

        int rightNode = 2 * nodePosition + 1;
        int nodeRightLeftMost = (nodeLeftMost + nodeRightMost) / 2 + 1;

        return Math.max(
                getMaxQuery(leftNode, nodeLeftMost, nodeLeftRightMost, leftInterval, rightInterval),
                getMaxQuery(rightNode, nodeRightLeftMost, nodeRightMost, leftInterval, rightInterval)
        );
    }

    private static boolean nodeRangeDoNotIntersectInterval(int nodeLeftMost, int nodeRightMost, int leftInterval, int rightInterval) {
        return nodeRightMost < leftInterval || rightInterval < nodeLeftMost;
    }

    private boolean isNodeRangeSubSetOfInterval(int nodeLeftMost, int nodeRightMost, int leftInterval, int rightInterval) {
        return leftInterval <= nodeLeftMost  &&  nodeRightMost <= rightInterval;
    }
}