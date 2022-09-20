package drll.problems.leetCodeContest.problem2;

import java.util.Arrays;

public class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int matches = 0;

        int trainersPosition = 0;
        for (int player : players) {
            while (trainersPosition < trainers.length &&
                    player > trainers[trainersPosition]) {
                trainersPosition++;
            }
            if (trainersPosition < trainers.length) {
                matches++;
                trainersPosition++;
            }
            if (trainersPosition == trainers.length) {
                break;
            }
        }

        return matches;
    }
}