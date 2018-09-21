package drll.problems.matrixLayerRotation;

public class Point {
    public int X;
    public int Y;

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
    public String toString() {
        return String.format("x: %s, y: %s", X, Y);
    }
}
