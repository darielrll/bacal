
package drll.problems.hacker_rank.big_sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Map<String, Integer> numbersCount = new HashMap<>();
        for (String number : unsorted) {
            numbersCount.compute(number, (key, value) -> (value == null) ? 1 : value + 1);
        }

        String[] sortedKeys = numbersCount.keySet().toArray(new String[0]);
        Arrays.sort(sortedKeys, Solution::compare);

        String[] sortedNumbers = new String[unsorted.length];
        int currentSortedPosition = 0;
        for (String key : sortedKeys) {

            Integer keyCount = numbersCount.get(key);
            int end = currentSortedPosition + keyCount;

            for (int j = currentSortedPosition; j < end; j++) {
                sortedNumbers[j] = key;
            }
            currentSortedPosition += keyCount;
        }
        return sortedNumbers;
    }

    static int compare(String number1, String number2){
        int comparison = number1.length() - number2.length();

        if (comparison == 0) {
            for (int i = 0; i < number1.length(); i++) {
                int result = number1.charAt(i) - number2.charAt(i);
                if (result != 0){
                    return result;
                }
            }
            return 0;
        }

        return comparison;
    }
}
