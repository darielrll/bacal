package drll.problems.leetcodeContest.problem3;

public class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        return peopleAwareOfSecret(n, delay, forget, 1) -1;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget, int startDay) {
        int peopleAware = 1;

        for (int i = startDay + delay; i < startDay + forget  &&  i <= n; i++) {
            peopleAware += peopleAwareOfSecret(n, delay, forget, i);
        }



        return peopleAware;
    }
}