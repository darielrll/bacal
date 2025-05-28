
package drll.problems.hacker_rank.missing_numbers;

import java.util.*;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] missing, int[] original) {

        HashMap<Integer, Integer> originalNumbersMap = getMapAnalysis(original);
        HashMap<Integer, Integer> missingNumbersMap = getMapAnalysis(missing);

        ArrayList<Integer> missingNumbers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : originalNumbersMap.entrySet()) {
            if (!missingNumbersMap.containsKey(entry.getKey())  ||
                (missingNumbersMap.containsKey(entry.getKey())  &&  !missingNumbersMap.get(entry.getKey()).equals(entry.getValue()))){
                missingNumbers.add(entry.getKey());
            }
        }

        int[] result = new int[missingNumbers.size()];
        for (int i = 0; i < missingNumbers.size(); i++) {
            result[i] = missingNumbers.get(i);
        }

        Arrays.sort(result);


        return result;
    }

    private static HashMap<Integer, Integer> getMapAnalysis(int[] numbers) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();

        for (int i : numbers) {
            if (numbersMap.containsKey(i)){
                numbersMap.put(i, numbersMap.get(i) + 1);
            }
            else{
                numbersMap.put(i, 1);
            }
        }

        return numbersMap;
    }
}