package drll.problems.hacker_rank.matrix_layer_rotation;

import java.util.Objects;

public class Point {
    public final int X;
    public final int Y;

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)){
            return false;
        }
        Point other = (Point)o;
        return X == other.X &&  Y == other.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public String toString() {
        return String.format("x: %s, y: %s", X, Y);
    }
}
