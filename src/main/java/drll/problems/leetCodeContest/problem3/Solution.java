package drll.problems.leetCodeContest.problem3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long numberOfWays(String s) {
        char[] chars = s.toCharArray();

        List<String> binaryNumber = new ArrayList<>();
        List<Integer> binaryNumberCount = new ArrayList<>();

        int startRangePosition = 0;
        for (int endRangePosition = 1; endRangePosition < chars.length; endRangePosition++) {
            if (chars[startRangePosition] != chars[endRangePosition]) {
                binaryNumber.add(chars[startRangePosition] == '0' ? "0" : "1");
                binaryNumberCount.add(endRangePosition - startRangePosition);

                startRangePosition = endRangePosition;
            }
        }
        binaryNumber.add(chars[startRangePosition] == '0' ? "0" : "1");
        binaryNumberCount.add(chars.length - startRangePosition);

        if (binaryNumber.size() < 3) {
            return 0;
        }

        int[] binaryNumberAccumulate = new int[binaryNumber.size()];
        for (int i = binaryNumber.size() - 1; i >= 0; i--) {
            binaryNumberAccumulate[i] = binaryNumberCount.get(i) +
                    ((i + 2) < binaryNumberAccumulate.length ? binaryNumberAccumulate[i + 2] : 0);
        }

        long numberOfWays = 0;

        boolean endInOne = "1".equals(binaryNumber.get(binaryNumber.size() - 1));
        int lastNumberCount = binaryNumberAccumulate[binaryNumberAccumulate.length - 1];
        for (int i = 0; i < binaryNumberAccumulate.length - 2; i++) {
            // "101"
            if("1".equals(binaryNumber.get(binaryNumber.size() - 1))){
                numberOfWays += binaryNumberCount.get(i)
                        * (binaryNumberAccumulate[i + 1] - (!endInOne ? lastNumberCount : 0))
                        * binaryNumberAccumulate[i + 2];
            }
            // "010"
            else{
                numberOfWays += binaryNumberCount.get(i)
                        * (binaryNumberAccumulate[i + 1] - (endInOne ? lastNumberCount : 0))
                        * binaryNumberAccumulate[i + 2];
            }

        }

//        // "010"
//        for (int i = 0; i < binaryNumber.size(); i++) {
//            if ("0".equals(binaryNumber.get(i))) {
//                for (int j = i + 1; j < binaryNumber.size(); j += 2) {
//                    for (int k = j + 1; k < binaryNumber.size(); k += 2) {
//                        numberOfWays += binaryNumberCount.get(i)
//                                * binaryNumberCount.get(j)
//                                * binaryNumberCount.get(k);
//                    }
//                }
//                i++;
//            }
//        }
//
//        // 101"
//        for (int i = 0; i < binaryNumber.size(); i++) {
//            if ("1".equals(binaryNumber.get(i))) {
//                for (int j = i + 1; j < binaryNumber.size(); j += 2) {
//                    for (int k = j + 1; k < binaryNumber.size(); k += 2) {
//                        numberOfWays += binaryNumberCount.get(i)
//                                * binaryNumberCount.get(j)
//                                * binaryNumberCount.get(k);
//                    }
//                }
//                i++;
//            }
//        }

        return numberOfWays;
    }
}