
package drll.problems.hacker_rank.greedy_florist;

import java.util.*;

public class GreedyFlorist {

    static int getMinimumCost(int numberOfFriends, int[] flowerPrices) {

        Arrays.sort(flowerPrices);
        int minimumCost = 0;
        for (int i = flowerPrices.length - 1; i >= 0; i--){
            minimumCost += (((flowerPrices.length - i - 1) / numberOfFriends) + 1) * flowerPrices[i];
        }
        return minimumCost;
    }
}