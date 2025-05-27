package drll.problems.custom.jobs_applications.count_maximum_teams;

import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int countMaximumTeams(List<Integer> skill, int teamSize, int maxDiff) {
        if(skill.size() < teamSize){
            return 0;
        }
        skill.sort(Comparator.naturalOrder());

        int teams = 0;
        int formingTeams = 0;
        while (formingTeams + teamSize - 1 < skill.size()) {
            int minSkillDev = formingTeams;
            int maxSkillDev = formingTeams + teamSize - 1;
            while(skill.get(maxSkillDev) - skill.get(minSkillDev) > maxDiff){
                minSkillDev++;
                maxSkillDev++;
                if(maxSkillDev >= skill.size()){
                    return teams;
                }
            }
            teams++;
            formingTeams = maxSkillDev + 1;
        }

        return teams;
    }
}