package drll.problems.leetcode.NumberOfValidClockTimes;

public class Solution {
    public int countTime(String time) {
        String[] splitTime = time.split(":");
        String hours = splitTime[0];
        String minutes = splitTime[1];

        int validHoursTimes = 1;
        int validMinutesTimes = 1;

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


        if(minutes.charAt(0) == '?'){
            validMinutesTimes = 6;
        }
        if(minutes.charAt(1) == '?'){
            validMinutesTimes = minutes.charAt(0) == '?' ? 60 : 10;
        }

        return validHoursTimes * validMinutesTimes;
    }
}