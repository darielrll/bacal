package drll.problems.leetCodeContest.problem4;

public class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long[] subSums = subSums(runningCosts);
        // int[] maxCharges = subMax(chargeTimes);
        Node[] maxSegmentTree = getMaxSegmentTree(chargeTimes);

        int maxConsecutive = 0;
        for (int k = 1; k <= chargeTimes.length - 1; k++) {
            int windowStart = 0;
            int windowEnd = windowStart + k - 1;
            boolean findNextK = false;
            while (windowEnd <= chargeTimes.length - 1){

                int maxCharge = getMaxForceBrute(chargeTimes, windowStart, windowEnd);
                int maxCharge2 = getMaxInSegment(maxSegmentTree[windowStart], maxSegmentTree[windowEnd]);
                long sum = getSubSum(subSums, windowStart, windowEnd);

                if(maxCharge != maxCharge2){
                    maxCharge2 = getMaxInSegment(maxSegmentTree[windowStart], maxSegmentTree[windowEnd]);
                }

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

    private int getMaxInSegment(Node start, Node end) {
        if(start.equals(end)){
            return start.value;
        }
        return getMaxInSegment(start.parent, end.parent);
    }

    private int getMaxForceBrute(int[] chargeTimes, int windowStart, int windowEnd) {
        int max = chargeTimes[windowStart];
        for (int i = windowStart + 1; i <= windowEnd; i++) {
            if(max < chargeTimes[i]){
                max = chargeTimes[i];
            }
        }
        return max;
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

    private long[] subSums(int[] numbers){
        long[] subSums = new long[numbers.length];
        subSums[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            subSums[i] = subSums[i - 1] + numbers[i];
        }
        return subSums;
    }

    private int[] subMax(int[] numbers) {
        int[] subMax = new int[numbers.length];
        subMax[0] = numbers[0];
        int max = subMax[0];
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
            subMax[i] = max;
        }
        return subMax;
    }

    private Node[] getMaxSegmentTree(int[] numbers){
        Node[] maxSegments = new Node[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            maxSegments[i] = new Node(numbers[i]);
        }
        buildTreeBottomUp(maxSegments);
        return maxSegments;
    }

    private void buildTreeBottomUp(Node[] level){
        if(level.length == 1){
            return;
        }
        Node[] levelUp = new Node[(level.length / 2) + (level.length % 2 == 0 ? 0 : 1)];
        int positionCovered = 0;
        for (int i = 0; i < level.length; i += 2) {
            Node parent;
            if( i + 1 < level.length){
                parent = new Node(Math.max(level[i].value, level[i + 1].value));
                level[i + 1].parent = parent;
            }
            else{
                parent = new Node(level[i].value);
            }
            level[i].parent = parent;
            levelUp[positionCovered] = parent;
            positionCovered++;
        }
        buildTreeBottomUp(levelUp);
    }
}

class Node{
    int value;
    Node parent;

    public Node(int number) {
        value = number;
    }
}