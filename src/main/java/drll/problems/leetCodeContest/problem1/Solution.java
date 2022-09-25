package drll.problems.leetCodeContest.problem1;

public class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        Date[] aliceDates = getTripDates(arriveAlice, leaveAlice);
        Date[] bobDates = getTripDates(arriveBob, leaveBob);

        int[] monthLineSweep = new int[13];
        for (int i = aliceDates[0].month; i <= aliceDates[1].month; i++) {
            monthLineSweep[i]++;
        }
        for (int i = bobDates[0].month; i <= bobDates[1].month; i++) {
            monthLineSweep[i]++;
        }

        int windowStart = 1;
        while(windowStart < monthLineSweep.length  &&  monthLineSweep[windowStart] != 2){
           windowStart++;
        }

        if(windowStart == 13){
            return 0;
        }

        int windowEnd = windowStart;
        while(windowEnd + 1 < monthLineSweep.length  &&  monthLineSweep[windowEnd + 1] == 2){
            windowEnd++;
        }

        int daysTogether = 0;

        Date start = getStartDate(windowStart, aliceDates, bobDates);
        Date end = getEndDate(windowEnd, aliceDates, bobDates);

        for (int i = windowStart; i <= windowEnd; i++) {

        }

        return daysTogether;

//        Date[] aliceDates = getTripDates(arriveAlice, leaveAlice);
//        Date[] bobDates = getTripDates(arriveBob, leaveBob);
//
//        if(aliceDates[1].compareTo(bobDates[0]) < 0 ||  bobDates[1].compareTo(aliceDates[0]) < 0){
//            return 0;
//        }
//        if(isSubSetAofB(aliceDates, bobDates)){
//            return differenceInDays(aliceDates[0], aliceDates[1]);
//        }
//        if(isSubSetAofB(bobDates, aliceDates)){
//            return differenceInDays(bobDates[0], bobDates[1]);
//        }
//
//        if(bobDates[0].compareTo(aliceDates[0]) < 0){
//            return differenceInDays(aliceDates[0], bobDates[1]);
//        }
//        return differenceInDays(bobDates[0], aliceDates[1]);
    }

    private Date getEndDate(int windowEnd, Date[] aliceDates, Date[] bobDates) {
        if(aliceDates[1].month == bobDates[1].month){
            if(aliceDates[1])
        }
        return null;
    }

    private Date getStartDate(int windowStart, Date[] aliceDates, Date[] bobDates) {
        return null;
    }

    private boolean isSubSetAofB(Date[] dateA, Date[] dateB) {
        return dateB[0].compareTo(dateA[0]) < 0  &&
                dateA[1].compareTo(dateB[1]) < 0;
    }

    private int differenceInDays(Date start, Date end) {
        if(start.month == end.month){
            return end.day - start.day + 1;
        }

        int[] daysOfMonth = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int differenceInDays = daysOfMonth[start.month] - start.day + 1;
        for(int i = start.month + 1; i < end.month; i++){
            differenceInDays += daysOfMonth[i];
        }
        differenceInDays += end.day;

        return differenceInDays;
    }

    private Date[]  getTripDates(String arrive, String leave) {
        String[] arriveInformation = arrive.split("-");
        String[] leaveInformation = leave.split("-");

        return new Date[]{
                new Date(Integer.parseInt(arriveInformation[0]), Integer.parseInt(arriveInformation[1])),
                new Date(Integer.parseInt(leaveInformation[0]), Integer.parseInt(leaveInformation[1]))
        };
    }



    class Date implements Comparable<Date>{
        private int day;
        private int month;


        public Date(int month, int day) {
            this.day = day;
            this.month = month;
        }

        @Override
        public int compareTo(Date date) {
            if(month < date.month){
                return -1;
            }
            else if(month > date.month){
                return 1;
            }
            if(day < date.day){
                return -1;
            }
            else if(day > date.day){
                return 1;
            }
            return 0;
        }
    }
}

