package drll.problems.leetcode.CountLatticePointsInsideACircle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<Point> latticePoints = new HashSet<>();

        for (int[] circle : circles) {
            int centerX = circle[0];
            int centerY = circle[1];
            int r = circle[2];

            for (int x = r - centerX; x <= r + centerX ; x++) {
                for (int y = r - centerY; y <= r + centerY ; y++) {
                    if(((x - centerX)*(x - centerX) + (y - centerY)*(y - centerY)) <= r*r){
                        latticePoints.add(new Point(x, y));
                    }
                }
            }
        }


        return latticePoints.size();
    }

    class Point{
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x*x * 10*10 + y*y*10*10*10;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point){
                Point point = (Point) obj;
                return x == point.x  &&  y == point.y;
            }
            return false;
        }
    }
}