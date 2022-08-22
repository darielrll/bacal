package drll.problems.leetCodeContest.MinimumHoursOfTrainingToWinACompetition;

public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int minHours = 0;

        for (int i = 0; i < energy.length; i++) {
            int opponentEnergy = energy[i];
            if(initialEnergy > opponentEnergy){
                initialEnergy -= opponentEnergy;
            }
            else {
                minHours += opponentEnergy - initialEnergy + 1;
                initialEnergy = 1;
            }

            int opponentExperience = experience[i];
            if(initialExperience > opponentExperience){
                initialExperience += opponentExperience;
            }
            else {
                minHours += opponentExperience - initialExperience + 1;
                initialExperience += opponentExperience - initialExperience + 1 + opponentExperience;
            }
        }

        return minHours;
    }
}