
package drll.problems.hacker_rank.insertionSortPart1;

import java.util.List;

public class InsertionSortPart1 {

    public static void insertionSort1(int n, List<Integer> arr) {
        System.out.println(insertionMovements(arr));
    }

    public static String insertionMovements(List<Integer> numbers) {
        Integer pivot = numbers.get(numbers.size() - 1);
        StringBuilder builder = new StringBuilder();
        for (int i = numbers.size() - 2; i >= 0; i--) {
            if(numbers.get(i) > pivot) {
                numbers.set(i + 1, numbers.get(i));
                builder.append(print(numbers));
                builder.append("\n");
                if( i == 0) {
                    numbers.set(i, pivot);
                    builder.append(print(numbers));
                }
                continue;
            }
            numbers.set(i + 1, pivot);
            builder.append(print(numbers));
            break;
        }
        return builder.toString();
    }

    public static String print(List<Integer> numbers){
        StringBuilder builder = new StringBuilder();

        for (Integer number : numbers) {
            builder.append(String.format("%s ", number));
        }

        return builder.substring(0, builder.length() - 1);
    }
}