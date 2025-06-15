
package drll.problems.hacker_rank.new_year_chaos;

public class NewYearChaos {

    static int calculateBribes(int[] q) {

        AVLExtended avlExtended = new AVLExtended();

        int bribes = 0;
        for (int i = 0; i < q.length; i++){
            int currentBribes = (i + 1) - q[i];
            if(currentBribes < 0) {
                if (currentBribes < -2) {
                    return -1;
                }
                bribes += currentBribes * -1;
            }
            else{
                avlExtended.add(new AVLNodeExtended(q[i]));
            }
        }
        return bribes + avlExtended.getBribes();
    }
}



