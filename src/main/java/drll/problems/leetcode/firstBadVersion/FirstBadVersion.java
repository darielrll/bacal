package drll.problems.leetcode.firstBadVersion;

public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        if(isBadVersion(1)){
            return 1;
        }
        return searchBadVersion(1, n);
    }

    private int searchBadVersion(int start, int end) {
        if (end - start == 1) {
            return end;
        }
        int middlePosition = getMiddlePosition(start, end);
        return isBadVersion(middlePosition)
                ? searchBadVersion(start, middlePosition)
                : searchBadVersion(middlePosition, end);
    }

    private int getMiddlePosition(int start, int end) {
        int middlePosition = (start + end) / 2;
        if(middlePosition < 0){
            Long bigStart = (long) start;
            Long bigEnd = (long) end;
            middlePosition = (int) ((bigStart + bigEnd) / 2);
        }
        return middlePosition;
    }
}