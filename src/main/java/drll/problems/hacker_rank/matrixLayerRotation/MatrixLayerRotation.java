
package drll.problems.hacker_rank.matrixLayerRotation;

import java.util.Scanner;
import java.util.stream.IntStream;

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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mnr = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        matrixRotation(matrix, r);
        scanner.close();

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix){
        StringBuffer buffer = new StringBuffer();
        for (int[] ints : matrix) {
            IntStream.range(0, matrix[0].length).mapToObj(j -> ints[j] + " ").forEach(buffer::append);
            buffer.append(System.getProperty("line.separator"));
        }
        System.out.print(buffer);
    }
}