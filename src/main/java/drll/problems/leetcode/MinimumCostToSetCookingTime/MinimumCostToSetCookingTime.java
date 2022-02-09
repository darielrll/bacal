package drll.problems.leetcode.MinimumCostToSetCookingTime;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostToSetCookingTime {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        List<String> cookTimes = new ArrayList<>();
        if(targetSeconds < 100){
            cookTimes.add(String.valueOf(targetSeconds));
        }

        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;
        if(minutes == 100){
            minutes--;
            seconds += 60;
        }
        do{
            String secondsString = seconds < 10 ? "0" + seconds : Integer.toString(seconds);
            cookTimes.add(String.valueOf(minutes).concat(secondsString));

            minutes--;
            seconds += 60;
        }
        while (minutes >= 0  &&  seconds <= 99);

        int minCostSetTime = Integer.MAX_VALUE;
        for (String time : cookTimes) {
            int cookTime = getMinCostSetTime(startAt, moveCost, pushCost, time);

            if (cookTime < minCostSetTime) {
                minCostSetTime = cookTime;
            }
        }

        return minCostSetTime;
    }

    private int getMinCostSetTime(int startAt, int moveCost, int pushCost, String cookTime) {
        int currentButton = startAt;
        int minCostSetTime = 0;
        char[] charArray = cookTime.toCharArray();

        for (char c : charArray) {
            int targetButton = Integer.parseInt(String.valueOf(c));
            if (currentButton != targetButton) {
                minCostSetTime += moveCost;
                currentButton = targetButton;
            }
            minCostSetTime += pushCost;
        }

        return minCostSetTime;
    }
}