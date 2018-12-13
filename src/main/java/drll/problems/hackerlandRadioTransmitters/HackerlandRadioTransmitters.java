
package drll.problems.hackerlandRadioTransmitters;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}