
package drll.problems.hackerRank.matrixLayerRotation;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PathDiscovererLayerTest {

    private PathDiscovererLayer pathDiscovererLayer;

    @Test
    void should_return_next_point_anti_clockwise_1(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, false);

        Point nextpoint = pathDiscovererLayer.next();

        assertThat(nextpoint).isEqualTo(new Point(0, 1));
    }

    @Test
    void should_return_next_point_anti_clockwise_2(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, false);

        for(int i = 0; i < 2; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(1, 1));
    }

    @Test
    void should_return_next_point_anti_clockwise_3(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, false);

        for(int i = 0; i < 3; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(1, 0));
    }

    @Test
    void should_return_next_point_anti_clockwise_4(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, false);

        for(int i = 0; i < 4; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(0, 0));
    }

    @Test
    void should_return_next_point_anti_clockwise_5(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, false);

        Point nextpoint = pathDiscovererLayer.next();

        assertThat(nextpoint).isEqualTo(new Point(1,2));
    }

    @Test
    void should_return_next_point_anti_clockwise_6(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, false);

        for(int i = 0; i < 4; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(2,4));
    }

    @Test
    void should_return_next_point_anti_clockwise_7(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, false);

        for(int i = 0; i < 5; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(2,3));
    }

    @Test
    void should_return_next_point_anti_clockwise_8(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, false);

        for(int i = 0; i < 8; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(1,1));
    }

    @Test
    void should_return_next_point_clockwise_9(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, true);

        Point nextpoint = pathDiscovererLayer.next();

        assertThat(nextpoint).isEqualTo(new Point(0, 1));
    }

    @Test
    void should_return_next_point_clockwise_10(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, true);

        for(int i = 0; i < 2; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(0, 0));
    }

    @Test
    void should_return_next_point_clockwise_11(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, true);

        for(int i = 0; i < 3; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(1, 0));
    }

    @Test
    void should_return_next_point_clockwise_12(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, true);

        for(int i = 0; i < 4; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(1, 1));
    }

    @Test
    void should_return_next_point_anti_clockwise_13(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, true);

        Point nextpoint = pathDiscovererLayer.next();

        assertThat(nextpoint).isEqualTo(new Point(1,4));
    }

    @Test
    void should_return_next_point_anti_clockwise_14(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, true);

        for(int i = 0; i < 4; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(1,1));
    }

    @Test
    void should_return_next_point_anti_clockwise_15(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, true);

        for(int i = 0; i < 5; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(2,1));
    }

    @Test
    void should_return_next_point_anti_clockwise_16(){
        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, true);

        for(int i = 0; i < 8; i++){
            pathDiscovererLayer.next();
        }

        Point currentPoint = pathDiscovererLayer.peek();

        assertThat(currentPoint).isEqualTo(new Point(2,4));
    }

    @Test
    void should_return_upper_left_corner_in_anti_clockwise_test_1(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, false);

        Point startPoint = pathDiscovererLayer.peek();

        assertThat(startPoint).isEqualTo(new Point(0,0));
    }

    @Test
    void should_return_down_right_corner_in_clockwise_test_1(){
        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, true);

        Point startPoint = pathDiscovererLayer.peek();

        assertThat(startPoint).isEqualTo(new Point(1,1));
    }

    @Test
    void should_return_upper_left_corner_in_anti_clockwise_test_2(){
        int[][] matrix = new int[4][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, false);

        Point startPoint = pathDiscovererLayer.peek();

        assertThat(startPoint).isEqualTo(new Point(1,1));
    }

    @Test
    void should_return_upper_left_corner_in_anti_clockwise_test_3(){
        int[][] matrix = new int[4][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(1, false);

        Point startPoint = pathDiscovererLayer.peek();

        assertThat(startPoint).isEqualTo(new Point(0,0));
    }

    @Test
    void should_return_down_right_corner_in_clockwise_test_2(){
        int[][] matrix = new int[4][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);
        pathDiscovererLayer.prepareForDiscoverPath(2, true);

        Point startPoint = pathDiscovererLayer.peek();

        assertThat(startPoint).isEqualTo(new Point(2,2));
    }

    @Test
    void should_return_perimeter_4_for_2rX2c_matrix(){

        int[][] matrix = new int[2][2];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);

        int perimeter = pathDiscovererLayer.calculateLayerPerimeter(1);

        assertThat(perimeter).isEqualTo(4);
    }

    @Test
    void should_return_perimeter_12_for_4rX4c_matrix_in_layer_1(){

        int[][] matrix = new int[4][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);

        int perimeter = pathDiscovererLayer.calculateLayerPerimeter(1);

        assertThat(perimeter).isEqualTo(12);
    }

    @Test
    void should_return_perimeter_4_for_4rX4c_matrix_in_layer_2(){

        int[][] matrix = new int[4][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);

        int perimeter = pathDiscovererLayer.calculateLayerPerimeter(2);

        assertThat(perimeter).isEqualTo(4);
    }

    @Test
    void should_return_perimeter_16_for_6rX4c_matrix_in_layer_1(){

        int[][] matrix = new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);

        int perimeter = pathDiscovererLayer.calculateLayerPerimeter(1);

        assertThat(perimeter).isEqualTo(16);
    }

    @Test
    void should_return_perimeter_8_for_6rX4c_matrix_in_layer_2(){

        int[][] matrix =  new int[6][4];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);

        int perimeter = pathDiscovererLayer.calculateLayerPerimeter(2);

        assertThat(perimeter).isEqualTo(8);
    }

    @Test
    void should_return_perimeter_16_for_4rX6c_matrix_in_layer_1(){

        int[][] matrix =  new int[4][6];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);

        int perimeter = pathDiscovererLayer.calculateLayerPerimeter(1);

        assertThat(perimeter).isEqualTo(16);
    }

    @Test
    void should_return_perimeter_8_for_4rX6c_matrix_in_layer_2(){

        int[][] matrix =  new int[4][6];
        pathDiscovererLayer = new PathDiscovererLayer(matrix);

        int perimeter = pathDiscovererLayer.calculateLayerPerimeter(2);

        assertThat(perimeter).isEqualTo(8);
    }
}