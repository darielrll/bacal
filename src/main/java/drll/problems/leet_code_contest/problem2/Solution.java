package drll.problems.leet_code_contest.problem2;

public class Solution {
    static class DataStream {
        private final int value;
        private final int k;
        private int countValue;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
            countValue = 0;
        }

        public boolean consec(int num) {
            countValue = (num == value) ? ++countValue : 0;
            return countValue >= k;
        }
    }
}