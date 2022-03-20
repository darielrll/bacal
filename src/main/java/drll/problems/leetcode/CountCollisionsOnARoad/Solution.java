package drll.problems.leetcode.CountCollisionsOnARoad;

public class Solution {
    public int countCollisions(String directions) {
        int collisions = 0;
        int rightDirection = 0;
        boolean staying = false;

        char[] dirs = directions.toCharArray();
        for (Character direction : dirs) {
            switch (direction) {
                case 'L':
                    if (rightDirection > 0) {
                        collisions += 2 + (rightDirection - 1);
                        rightDirection = 0;
                        staying = true;
                        continue;
                    }
                    if (staying) {
                        collisions++;
                    }
                    break;
                case 'R':
                    rightDirection++;
                    break;
                case 'S':
                    staying = true;
                    if (rightDirection > 0) {
                        collisions += 1 + (rightDirection - 1);
                        rightDirection = 0;
                    }
                    break;
            }
        }
        return collisions;
    }
}