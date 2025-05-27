
package drll.problems.hacker_rank.matrix_layer_rotation;

public class PathDiscovererLayer {
    private final int[][] matrix;

    private int layer;
    private int direction;
    private final int[][] pathCalculator;
    private boolean clockwise;
    private Point currentPoint;

    public PathDiscovererLayer(int[][] matrix) {
        this.matrix = matrix;

        /*
         *              --> anti-clockwise
         *              <-- clockwise
         *
         *               0       1     2     3
         *            ____________________________
         * f(y) -> 0  |   1  |   0   | -1 |  0   |
         *            ----------------------------
         * c(x) -> 1  |   0  |   1   | 0  |  -1  |
         *            ----------------------------
         *            | down | right | up | left |
         *
         * */
        pathCalculator = new int[][]{{1, 0, -1, 0},
                                      {0, 1, 0, -1}};
    }

    public void prepareForDiscoverPath(int layer, boolean clockwise) {
        this.layer = layer;
        this.clockwise = clockwise;
        if(clockwise){
            direction = 3;
            currentPoint = new Point(layer + getWith(layer) - 2,
                                     layer + getLong(layer) - 2);
        }
        else{
            direction = 0;
            currentPoint = new Point(layer -1, layer -1);
        }
    }

    public Point peek(){
        return currentPoint;
    }

    public Point next(){

        Point nextPoint = calculateNextPoint();

        while(!pointBelongToLayer(nextPoint)){
            if(clockwise){
                direction = (4 - (5 - direction) % 4 ) % 4;
            }
            else{
                direction = (direction + 1) % 4;
            }
            nextPoint = calculateNextPoint();
        }
        currentPoint = nextPoint;
        return currentPoint;
    }

    private boolean pointBelongToLayer(Point point) {

        if(direction == 0  ||  direction == 2){
            // vertical
            return point.Y >= layer - 1  &&  point.Y < (layer + getLong(layer) - 1);
        }
        else{
            // horizontal
            return point.X >= layer - 1  &&  point.X < (layer + getWith(layer) - 1);
        }
    }

    private Point calculateNextPoint(){
        return new Point(currentPoint.X + pathCalculator[1][direction],
                         currentPoint.Y + pathCalculator[0][direction]);
    }

    public int calculateLayerPerimeter(int layer) {
        return 2 * (getWith(layer) - 2 + getLong(layer));
    }

    private int getLong(int layer){
        return matrix.length - (layer - 1) * 2;
    }

    private int getWith(int layer){
        return matrix[0].length - (layer - 1) * 2;
    }
}