
package drll.problems.hacker_rank.matrix_layer_rotation;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    public static void matrixRotation(int[][] matrix, int rotations) {

        int layer = Math.min(matrix.length / 2, matrix[0].length / 2);

        PathDiscovererLayer pathFinder = new PathDiscovererLayer(matrix);

        while(layer > 0){
            int perimeter = pathFinder.calculateLayerPerimeter(layer);
            int effectiveRotations = rotations % perimeter;

            boolean clockwise = false;

            if(effectiveRotations > perimeter / 2){
                clockwise = true;
                effectiveRotations = perimeter - effectiveRotations;
            }
            if(effectiveRotations != 0){
                pathFinder.prepareForDiscoverPath(layer, clockwise);
                rotateMatrixLayer(matrix, effectiveRotations, pathFinder);
            }
            layer--;
        }
    }

    private static void rotateMatrixLayer(int[][] matrix, int rotations, PathDiscovererLayer pathFinder) {

        // esto se puede mejorar haciendo que no rote paso a paso, sino que ponga el elemento a la primera
        // vez en donde debe ir, has esta mejora si es necesaria.

        while (rotations-- > 0){
            rotateLayer(matrix, pathFinder);
        }
    }

    private static void rotateLayer(int[][] matrix, PathDiscovererLayer pathFinder) {

        // esto se puede mejorar haciendo que no rote paso a paso, sino que ponga el elemento a la primera
        // vez en donde debe ir, has esta mejora si es necesaria.

        int currentValue = matrix[pathFinder.peek().Y][pathFinder.peek().X];
        Point nextPoint = pathFinder.next();

        Point initialPoint = nextPoint;

        do{
            int tmp = matrix[nextPoint.Y][nextPoint.X];
            matrix[nextPoint.Y][nextPoint.X] = currentValue;

            nextPoint = pathFinder.next();
            currentValue = tmp;
        }while (!initialPoint.equals(nextPoint));
    }
}