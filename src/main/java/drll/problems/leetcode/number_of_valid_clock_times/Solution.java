package drll.problems.leetcode.number_of_valid_clock_times;

public class Solution {
    public int countTime(String time) {
        String[] splitTime = time.split(":");

        String hour = splitTime[0];
        String minute = splitTime[1];
        return getValidHoursTimes(hour.charAt(0), hour.charAt(1)) *
                getValidMinutesTimes(minute.charAt(0), minute.charAt(1));
    }

    private static int getValidHoursTimes(char leftDigitHour, char rightDigitHour) {
        int validHoursTimes = 1;

        if (leftDigitHour == '?') {
            if (rightDigitHour == '?') {
                validHoursTimes = 24;
            } else {
                validHoursTimes = Integer.parseInt(String.valueOf(rightDigitHour)) > 3 ? 2 : 3;
            }
        } else if (rightDigitHour == '?') {
            validHoursTimes = Integer.parseInt(String.valueOf(leftDigitHour)) < 2 ? 10 : 4;
        }
        return validHoursTimes;
    }

    private static int getValidMinutesTimes(char leftDigitMinute, char rightDigitMinute) {
        int validMinutesTimes = 1;
        if(leftDigitMinute == '?'){
            validMinutesTimes = 6;
        }
        if(rightDigitMinute == '?'){
            validMinutesTimes *= 10;
        }
        return validMinutesTimes;
    }
}