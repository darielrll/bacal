
package drll.problems.hacker_rank.hackerland_radio_transmitters;

import java.util.*;

public class HackerlandRadioTransmitters {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {

        if (x.length == 1){
            return 1;
        }

        Arrays.sort(x);
        int antennae = 0;

        int i = 0;
        while(i < x.length){
            int realMiddlePosition = getEndSegmentPosition(x, k, i);
            if(realMiddlePosition == i){
                 i++;
            }
            else {
                int realEndPosition = getEndSegmentPosition(x, k, realMiddlePosition);
                i = ++realEndPosition;
            }
            antennae++;
        }

        return antennae;
    }

    private static int getEndSegmentPosition(int[] x, int radio, int startPosition) {
        int expectedMiddleValue = x[startPosition] + radio;
        int realMiddlePosition = startPosition;
        while (realMiddlePosition + 1 < x.length  &&  x[realMiddlePosition + 1] <= expectedMiddleValue) {
            realMiddlePosition++;
        }
        return realMiddlePosition;
    }
}