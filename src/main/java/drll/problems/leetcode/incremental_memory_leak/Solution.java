package drll.problems.leetcode.incremental_memory_leak;

class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int[] result = new int[]{1, memory1, memory2};

        do {
            int memory = result[0];
            int availableStickPosition = result[1] >= result[2] ? 1 : 2;
            if(memory <= result[availableStickPosition]){
                result[availableStickPosition] -= memory;
                result[0]++;
            }
            else {
                break;
            }
        }
        while(true);

        return result;
    }
}