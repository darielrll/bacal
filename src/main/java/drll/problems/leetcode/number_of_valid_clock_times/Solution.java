package drll.problems.leetcode.number_of_valid_clock_times;

public class Solution {
    public int countTime(String time) {
        String[] splitTime = time.split(":");
        String hours = splitTime[0];

        int validHoursTimes = 1;

        if(hours.charAt(0) == '?'){
            if(hours.charAt(1) == '?'){
                validHoursTimes = 3;
            }
            else{
                int hour = Integer.parseInt(String.valueOf(hours.charAt(1)));
                validHoursTimes = hour < 4 ? 3 : 2;
            }
        }
        if(hours.charAt(1) == '?'){
            if(hours.charAt(0) == '?'){
                validHoursTimes = 24;
            }
            else{
                validHoursTimes = hours.charAt(0) == '0' || hours.charAt(0) == '1' ? 10 : 4;
            }
        }

        return validHoursTimes * getValidMinutesTimes(splitTime[1]);
    }

    private static int getValidMinutesTimes(String minutes) {
        int validMinutesTimes = 1;
        if(minutes.charAt(0) == '?'){
            validMinutesTimes = 6;
        }
        if(minutes.charAt(1) == '?'){
            validMinutesTimes *= 10;
        }
        return validMinutesTimes;
    }
}