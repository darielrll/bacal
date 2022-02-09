
package drll.problems.hackerRank.iceCreamParlor;

import java.util.Arrays;
import java.util.List;

public class IceCreamParlor {

    static List<Integer> iceCreamParlor(int m, List<Integer> arr) {
        for (int sunnyPosition = 0, size = arr.size(); sunnyPosition < size; sunnyPosition++) {
            for (int johnnyPosition = sunnyPosition + 1; johnnyPosition < size; johnnyPosition++) {
                int allTheMoney = arr.get(sunnyPosition) + arr.get(johnnyPosition);

                if (allTheMoney == m) {
                    return Arrays.asList(sunnyPosition + 1, johnnyPosition + 1);
                }
            }
        }
        return null;
    }
}