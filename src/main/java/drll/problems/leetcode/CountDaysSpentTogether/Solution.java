package drll.problems.leetcode.CountDaysSpentTogether;

public class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        Date aliceArrive = new Date(arriveAlice);
        Date aliceLeave =  new Date(leaveAlice);
        Date bobArrive = new Date(arriveBob);
        Date bobLeave =  new Date(leaveBob);

        int[] daysOfMonth = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthEndIndex = new int[daysOfMonth.length];

        for (int i = 1; i < daysOfMonth.length; i++) {
            monthEndIndex[i] = monthEndIndex[i - 1] + daysOfMonth[i];
        }

        int[] daysLineSweep = new int[366];

        for (int start = monthEndIndex[aliceArrive.month - 1] + aliceArrive.day,
                 end = monthEndIndex[aliceLeave.month - 1] + aliceLeave.day;
             start <= end; start++) {
            daysLineSweep[start]++;
        }

        int daysTogether = 0;

        for (int start = monthEndIndex[bobArrive.month - 1] + bobArrive.day,
                 end = monthEndIndex[bobLeave.month - 1] + bobLeave.day;
             start <= end; start++) {
            daysLineSweep[start]++;
            if(daysLineSweep[start] == 2){
                daysTogether++;
            }
        }

        return daysTogether;
    }

    static class Date {
        private final int day, month;

        public Date(String date) {
            String[] dateInformation = date.split("-");

            month = Integer.parseInt(dateInformation[0]);
            day = Integer.parseInt(dateInformation[1]);
        }
    }
}

