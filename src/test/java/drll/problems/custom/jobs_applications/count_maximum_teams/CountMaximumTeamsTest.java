package drll.problems.custom.jobs_applications.count_maximum_teams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CountMaximumTeamsTest {

    @Test
    void should_return_correctly_for_test_case1() {
        List<Integer> skills = new ArrayList<Integer>();
        skills.add(3);
        skills.add(4);
        skills.add(3);
        skills.add(1);
        skills.add(6);
        skills.add(5);

        assertThat(Solution.countMaximumTeams(skills, 3, 2))
                .isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        List<Integer> skills = new ArrayList<Integer>();
        skills.add(5);
        skills.add(1);
        skills.add(2);
        skills.add(1);
        skills.add(4);
        skills.add(5);

        assertThat(Solution.countMaximumTeams(skills, 3, 2))
                .isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        List<Integer> skills = new ArrayList<Integer>();
        skills.add(9);
        skills.add(3);
        skills.add(5);
        skills.add(7);
        skills.add(1);

        assertThat(Solution.countMaximumTeams(skills, 2, 1))
                .isZero();
    }

    @Test
    void should_return_0_when_skills_is_less_than_team_size() {
        List<Integer> skills = new ArrayList<Integer>();
        skills.add(9);
        skills.add(3);
        skills.add(5);
        skills.add(7);
        skills.add(1);

        assertThat(Solution.countMaximumTeams(skills, 7, 1))
                .isZero();
    }

    @Test
    void should_return_0_when_team_finding_is_outside_of_the_border_of_skills() {
        List<Integer> skills = new ArrayList<Integer>();
        skills.add(3);
        skills.add(4);
        skills.add(3);
        skills.add(1);
        skills.add(6);
        skills.add(5);

        assertThat(Solution.countMaximumTeams(skills, 6, 2))
                .isZero();
    }
}