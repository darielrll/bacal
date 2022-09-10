package drll.problems.leetCodeContest.MinimumAmountOfTimeToCollectGarbage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        List<List<Integer>> paperSchedule = new ArrayList<>();
        List<List<Integer>> glassSchedule = new ArrayList<>();
        List<List<Integer>> metalSchedule = new ArrayList<>();

        for (int i = 0; i < garbage.length; i++) {
            char[] houseGarbageAssortment = garbage[i].toCharArray();
            int paperCount = 0;
            int glassCount = 0;
            int metalCount = 0;
            for (char c : houseGarbageAssortment) {
                if ('G' == c) {
                    glassCount++;
                } else if ('M' == c) {
                    metalCount++;
                } else {
                    paperCount++;
                }
            }
            if(paperCount > 0){
                paperSchedule.add(Arrays.asList(i, paperCount));
            }
            if(glassCount > 0){
                glassSchedule.add(Arrays.asList(i, glassCount));
            }
            if(metalCount > 0){
                metalSchedule.add(Arrays.asList(i, metalCount));
            }
        }

        return getTruckTime(travel, paperSchedule) +
                getTruckTime(travel, glassSchedule) +
                getTruckTime(travel, metalSchedule);
    }

    private int getTruckTime(int[] travel, List<List<Integer>> garbageSchedule) {
        int lastVisitedHouse = 0;
        int truckTime = 0;
        for (List<Integer> garbage : garbageSchedule) {
            Integer house = garbage.get(0);
            Integer garbageAmount = garbage.get(1);

            truckTime += distanceBetweenHouse(lastVisitedHouse, house, travel) + garbageAmount;

            lastVisitedHouse = house;
        }
        return truckTime;
    }

    private int distanceBetweenHouse(int from, int to, int[] travel){
        int distance = 0;

        while (from < to){
            distance += travel[from++];
        }

        return distance;
    }
}