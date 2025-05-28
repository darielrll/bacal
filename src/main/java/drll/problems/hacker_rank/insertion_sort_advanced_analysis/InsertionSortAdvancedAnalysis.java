
package drll.problems.hacker_rank.insertion_sort_advanced_analysis;


public class InsertionSortAdvancedAnalysis {

    public static long insertionSort(int[] arr) {
        AVLTreeInsertionAnalysis tree = new AVLTreeInsertionAnalysis();
        for (int i = 0; i < arr.length; i++){
            tree.add(new InsertionAnalysis(arr[i]));
        }
        return tree.getShifts();
    }
}