
package drll.problems.hackerRank.bigSorting;

//import common.Utils;

import java.util.Arrays;

public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted, BigSorting::compare);

        return unsorted;
    }

    static int compare(String number1, String number2){
        if(number1.length() > number2.length()){
            return 1;
        }
        if(number1.length() < number2.length()){
            return -1;
        }
        for (int i = 0; i < number1.length(); i++) {
            int result = Character.compare(number1.charAt(i), number2.charAt(i));
            if (result != 0){
                return result;
            }
        }

        return 0;
    }
}
