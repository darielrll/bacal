package drll.problems.leetcode.DesignANumberContainerSystem;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public Object[] testNumberContainer(String[] instructions, int[][] parameters) {
        NumberContainers numberContainers = new NumberContainers();
        Object[] response = new Object[instructions.length];
        response[0] = null;
        for (int i = 1; i < instructions.length; i++) {
            if ("find".equals(instructions[i])) {
                response[i] = numberContainers.find(parameters[i][0]);
            } else {
                numberContainers.change(parameters[i][0], parameters[i][1]);
                response[i] = null;
            }
        }
        return response;
    }
}

class NumberContainers {
    private final HashMap<Integer, Integer> indexMap;
    private final HashMap<Integer, PriorityQueue<Integer>> numberMap;

    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }

    public int find(int number) {
        if(numberMap.containsKey(number)){
            return numberMap.get(number).peek();
        }
        return -1;
    }

    public void change(int index, int number) {
        if(indexMap.containsKey(index)){
            replaceIndex(index, number);
        }
        else {
            addNewIndex(index, number);
        }
    }

    private void addNewIndex(int index, int number) {
        PriorityQueue<Integer> indexes = getIntegerPriorityQueue(number);
        indexes.add(index);
        numberMap.putIfAbsent(number, indexes);
        indexMap.put(index, number);
    }

    private void replaceIndex(int index, int number) {
        removeIndexFromNumber(index);
        updatePairNumberIndex(index, number);

        indexMap.replace(index, number);
    }

    private void updatePairNumberIndex(int index, int number) {
        PriorityQueue<Integer> indexes = getIntegerPriorityQueue(number);

        if(numberMap.containsKey(number)){
            indexes.remove(index);
        }
        if(!indexes.contains(index)){
            indexes.add(index);
        }

        numberMap.putIfAbsent(number, indexes);
    }

    private void removeIndexFromNumber(int index) {
        Integer numberToBeReplaced = indexMap.get(index);
        PriorityQueue<Integer> indexes = numberMap.get(numberToBeReplaced);
        indexes.remove(index);

        if (indexes.isEmpty()){
            numberMap.remove(numberToBeReplaced);
        }
        else {
            numberMap.replace(numberToBeReplaced, indexes);
        }
    }

    private PriorityQueue<Integer> getIntegerPriorityQueue(int number) {
        return numberMap.containsKey(number)
                ? numberMap.get(number)
                : new PriorityQueue<>();
    }
}