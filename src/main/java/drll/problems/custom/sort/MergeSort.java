package drll.problems.custom.sort;

public class MergeSort {
    public int[] mergeSort(int[] list) {
        return mergeSort(list, 0, list.length - 1);
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if(start == end){
            return new int[]{nums[start]};
        }
        int middle = (start + end) / 2;
        int[] leftSide = mergeSort(nums, start, middle);
        int[] rightSide = mergeSort(nums, middle + 1, end);
        return merge(leftSide, rightSide);
    }

    private int[] merge(int[] leftSide, int[] rightSide) {
        int[] ordered = new int[leftSide.length + rightSide.length];

        int pointLeft = 0;
        int pointRight = 0;
        int pointOrdered = 0;

        while(pointLeft < leftSide.length  &&  pointRight < rightSide.length){
            if (leftSide[pointLeft] < rightSide[pointRight]) {
                ordered[pointOrdered] = leftSide[pointLeft];
                pointLeft++;
            }
            else{
                ordered[pointOrdered] = rightSide[pointRight];
                pointRight++;
            }
            pointOrdered++;
        }

        if(pointLeft < leftSide.length){
            for (int i = pointLeft; i < leftSide.length; i++) {
                ordered[pointOrdered++] = leftSide[i];
            }
        }
        else{
            for (int i = pointRight; i < rightSide.length; i++) {
                ordered[pointOrdered++] = rightSide[i];
            }
        }

        return ordered;
    }
}
