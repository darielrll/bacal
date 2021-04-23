package drll.problems.leetcode.binarySearchTreeToGreaterSumTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void should_return_correctly_for_test_case1() {
        Integer[] treeValues = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};

        TreeNode tree = solution.bstToGst(buildTree(treeValues));

        Integer[] treeExpected = {30,36,21,36,35,26,15,null,null,null,33,null,null,null,8};
        assertThat(buildTreeValues(tree)).isEqualTo(treeExpected);
    }

    private TreeNode buildTree(Integer[] nodeRows){
        TreeNode tree = new TreeNode();

        for (int i = 0; i < ; i++) {
            
        }

        

        return tree;
    }

    private Integer[] buildTreeValues(TreeNode tree){
        return null;
    }
}