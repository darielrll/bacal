package drll.problems.leetCodeContest.problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int minBitFlips(int start, int goal) {
        List<Integer> binaryStart = convertToBinary(start);
        List<Integer> binaryGoal = convertToBinary(goal);

        int minimumBitFlipsRL = Math.abs(binaryStart.size() - binaryGoal.size());
        int minimumBitFlipsLR = minimumBitFlipsRL;

        for (int b = binaryStart.size() - 1, g = binaryGoal.size() - 1; b >= 0  &&   g >= 0; b--, g--) {
            if(!binaryStart.get(b).equals(binaryGoal.get(g))){
                minimumBitFlipsRL++;
            }
        }

        if(binaryStart.get(binaryStart.size() - 1) != 0){
            for (int b = 0, g = 0; b < binaryStart.size()  &&   g < binaryGoal.size(); b++, g++) {
                if(!binaryStart.get(b).equals(binaryGoal.get(g))){
                    minimumBitFlipsLR++;
                }
            }
            return Math.min(minimumBitFlipsRL, minimumBitFlipsLR);
        }
        return minimumBitFlipsRL;
    }

    private List<Integer> convertToBinary(int number){
        List<Integer> binary = new LinkedList<>();

        while (number >= 2){
            int cociente = number / 2;
            int resto = number % 2;
            binary.add(0, resto);
            number = cociente;
        }
        binary.add(0, number);
        return binary;
    }
}