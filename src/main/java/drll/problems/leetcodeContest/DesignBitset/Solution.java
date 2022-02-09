package drll.problems.leetcodeContest.DesignBitset;

public class Solution {
    public int search(int target) {
        return -1;
    }

    class Bitset {
        private boolean[] bitset;
        private int count;

        public Bitset(int size) {
            bitset = new boolean[size];
        }

        public void fix(int idx) {
            if(!bitset[idx]) {
                bitset[idx] = true;
                count++;
            }
        }

        public void unfix(int idx) {
            if(bitset[idx]){
                bitset[idx] = false;
                if(count > 0){
                    count--;
                }
            }
        }

        public void flip() {
            for (int i = 0; i < bitset.length; i++) {
                if(bitset[i]){
                    if(count > 0){
                        count--;
                    }
                    bitset[i] = false;
                }
                else{
                    bitset[i] = true;
                    count++;
                }
            }
        }

        public boolean all() {
            for (boolean b : bitset) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }

        public boolean one() {
            for (boolean b : bitset) {
                if (b) {
                    return true;
                }
            }
            return false;
        }

        public int count() {
            return count;
        }

        public String toString() {
            StringBuilder toString = new StringBuilder();
            for (boolean b : bitset) {
                toString.append(b ? "1" : "0");
            }
            return toString.toString();
        }
    }
}