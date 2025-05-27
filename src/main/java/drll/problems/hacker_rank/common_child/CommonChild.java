
package drll.problems.hacker_rank.common_child;

public class CommonChild {
    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        
        int[][] memory = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < memory.length; i++) {
            memory[0][i] = 0;
        }
        for (int i = 0; i < memory[0].length; i++) {
            memory[i][0] = 0;
        }
        for (int i = 1; i < memory.length; i++) {
            for (int j = 1; j < memory[0].length; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    memory[i][j] = 1 + memory[i - 1][j - 1];
                }
                else{
                    memory[i][j] = Math.max(memory[i][j - 1],
                                            memory[i - 1][j]);
                }
            }
        }
        
        return memory[memory.length - 1][memory[0].length - 1];
    }
}
