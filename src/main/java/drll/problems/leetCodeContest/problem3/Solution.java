package drll.problems.leetCodeContest.problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int totalSteps(int[] nums) {


//        int lastUpTendencyStart = 0;
//        int lastUpTendencyEnd = 0;
//        int lastUpNumber = nums[0];
//        int maxNonUpSegmentLength = 0;
//
//        int lastUpNumberInTendency = lastUpNumber;
//        int lastUpNumberInTendencyPosition = 0;
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[lastUpTendencyEnd] <= nums[i]){
//                lastUpTendencyEnd++;
//
//                if(nums[i] < lastUpNumber){
//                    lastUpNumberInTendency = nums[i];
//                    lastUpNumberInTendencyPosition = i;
//                }
//            }
//            else {
//                if(lastUpNumber > nums[lastUpTendencyEnd]){
//                    int currentDownTendencyLong = lastUpTendencyEnd - lastUpTendencyStart + 1;
//                    if(maxNonUpSegmentLength < currentDownTendencyLong){
//                        maxNonUpSegmentLength = currentDownTendencyLong;
//                    }
//                }
//                else{
//                    int currentDownTendencyLong = lastUpNumberInTendencyPosition - lastUpTendencyStart + 1;
//                    if(maxNonUpSegmentLength < currentDownTendencyLong){
//                        maxNonUpSegmentLength = currentDownTendencyLong;
//                    }
//                }
//
//                lastUpTendencyStart = i;
//                lastUpTendencyEnd = i;
//
//                lastUpNumberInTendency = nums[i];
//                lastUpNumberInTendencyPosition = i;
//            }
//        }
//
//        return maxNonUpSegmentLength;


//        int lastMaximum = nums[0];
//        int lastMaximumPosition = 0;
//        int maxDownTendencyLong = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (lastMaximum <= nums[i]){
//                int currentDownTendencyLong = i - lastMaximumPosition - 1;
//                if( currentDownTendencyLong > maxDownTendencyLong ){
//                    maxDownTendencyLong = currentDownTendencyLong;
//                }
//
//                lastMaximum = nums[i];
//                lastMaximumPosition = i;
//            }
//        }
//
//        return maxDownTendencyLong;



//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//
//        int totalSteps = 0;
//        List<Integer> tmp;
//        do{
//            tmp = new ArrayList<>();
//            tmp.add(list.get(0));
//            for (int i = 1; i < list.size(); i++) {
//                if(list.get(i - 1) <= list.get(i)){
//                    tmp.add(list.get(i));
//                }
//            }
//            if(tmp.size() == list.size()){
//                break;
//            }
//            else{
//                totalSteps++;
//            }
//            list = tmp;
//        }
//        while (tmp.size() != 1);
//
//        return totalSteps;
    }
}