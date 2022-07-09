package drll.problems.leetCodeContest.problem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        PriorityQueue<SquareDifference> squareDifferences = new PriorityQueue<>(
                (o1, o2) -> Math.abs(o2.difference) - Math.abs(o1.difference)
        );

        for (int i = 0; i < nums1.length; i++) {
            squareDifferences.add(new SquareDifference(nums1[i], nums2[i]));
        }

        List<SquareDifference> tmpList = new ArrayList<>();
        boolean hasModifications = false;
        while (k1 > 0   &&  !squareDifferences.isEmpty()){
            SquareDifference squareDifference = squareDifferences.poll();
            int tmpDiffSubtracting = (squareDifference.digit1 - 1) - squareDifference.digit2;
            int tmpDiffAdding = (squareDifference.digit1 + 1) - squareDifference.digit2;
            if(Math.abs(tmpDiffSubtracting) < Math.abs(squareDifference.difference)){
                squareDifference.digit1 = squareDifference.digit1 - 1;
                squareDifference.difference = tmpDiffSubtracting;
                k1--;
                squareDifferences.add(squareDifference);
                hasModifications = true;
            } else if (Math.abs(tmpDiffAdding) < Math.abs(squareDifference.difference)) {
                squareDifference.digit1 = squareDifference.digit1 + 1;
                squareDifference.difference = tmpDiffAdding;
                k1--;
                squareDifferences.add(squareDifference);
                hasModifications = true;
            } else{
                tmpList.add(squareDifference);
            }
            if(squareDifferences.isEmpty()  && k1 > 0  && hasModifications){
                squareDifferences.addAll(tmpList);
                tmpList.clear();
                hasModifications = false;
            }
        }
        squareDifferences.addAll(tmpList);
        tmpList.clear();


        hasModifications = false;
        while (k2 > 0  &&  !squareDifferences.isEmpty()){
            SquareDifference squareDifference = squareDifferences.poll();
            int tmpDiffSubtracting = squareDifference.digit1 - (squareDifference.digit2 - 1);
            int tmpDiffAdding = squareDifference.digit1 - (squareDifference.digit2 + 1);
            if(Math.abs(tmpDiffSubtracting) < Math.abs(squareDifference.difference)){
                squareDifference.digit2 = squareDifference.digit2 - 1;
                squareDifference.difference = tmpDiffSubtracting;
                k2--;
                squareDifferences.add(squareDifference);
                hasModifications = true;
            }
            else if (Math.abs(tmpDiffAdding) < Math.abs(squareDifference.difference)) {
                squareDifference.digit2 = squareDifference.digit2 + 1;
                squareDifference.difference = tmpDiffAdding;
                k2--;
                squareDifferences.add(squareDifference);
                hasModifications = true;
            }else{
                tmpList.add(squareDifference);
            }
            if(squareDifferences.isEmpty()  && k2 > 0  && hasModifications){
                squareDifferences.addAll(tmpList);
                tmpList.clear();
                hasModifications = false;
            }
        }
        squareDifferences.addAll(tmpList);

        long sumSquareDifference = 0;

        while (!squareDifferences.isEmpty()){
            SquareDifference squareDifference = squareDifferences.poll();
            sumSquareDifference += (long)squareDifference.difference * (long)squareDifference.difference;
        }

        return sumSquareDifference;
    }

    class SquareDifference{
        int digit1;
        int digit2;
        int difference;

        public SquareDifference(int digit1, int digit2) {
            this.digit1 = digit1;
            this.digit2 = digit2;
            difference = digit1 - digit2;
        }
    }
}