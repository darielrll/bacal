package drll.problems.leetcodeContest.DesignBitset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        Object[] expectedResults = new Object[]{null,null,null,null,false,null,null,true,null,2,"01010"};

        String[] commands = {"Bitset", "fix", "fix", "flip", "all", "unfix", "flip", "one", "unfix", "count", "toString"};
//        int[] commandResults = new int[]{{[5],[3],[1],[],[],[0],[],[],[0],[],[]}};

    }

    private Object[] processOperations(String[] commands, int[][] parameters){
        Solution.Bitset bitset = null;
        Object[] result = new Object[commands.length];

        for (int i = 0; i < commands.length; i++) {
            switch(commands[i]) {
                case "Bitset":
                    bitset = new Solution.Bitset(parameters[0][i]);
                    result[i] = null;
                    break;
                case "fix":
                    bitset.fix(parameters[0][i]);
                    result[i] = null;
                    break;
                case "flip":
                    bitset.flip();
                    result[i] = null;
                    break;
                case "all":
                    result[i] = bitset.all();
                    break;
                case "unfix":
                    bitset.unfix(parameters[0][i]);
                    result[i] = null;
                    break;
                case "one":
                    result[i] = bitset.one();
                    break;
                case "count":
                    result[i] = bitset.count();
                    break;
                case "toString":
                    result[i] = bitset.toString();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + commands[i]);
            }
        }

        return result;
    }
}