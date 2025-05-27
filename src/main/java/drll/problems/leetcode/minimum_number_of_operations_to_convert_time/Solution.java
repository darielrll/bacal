package drll.problems.leetcode.minimum_number_of_operations_to_convert_time;

public class Solution {
    public int convertTime(String current, String correct) {
        int minutesDifference = timeToMinutes(correct) - timeToMinutes(current);
        int operations = 0;

        while (minutesDifference > 0){
            if(minutesDifference / 60 > 0){
                operations += minutesDifference / 60;
                minutesDifference %= 60;
            }
            else if(minutesDifference / 15 > 0){
                operations += minutesDifference / 15;
                minutesDifference %= 15;
            }
            else if(minutesDifference / 5 > 0){
                operations += minutesDifference / 5;
                minutesDifference %= 5;
            } else{
                operations += minutesDifference;
                minutesDifference = 0;
            }
        }

        return operations;
    }

    private static int timeToMinutes(String time24){
        int hour = Integer.parseInt(time24.substring(0, 2));
        int minutes = Integer.parseInt(time24.substring(3));

        return hour * 60 + minutes;
    }
}