
package drll.problems.largestRectangle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class LargestRectangleTest {

    @Test
    public void should_work_for_test_case_1(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{3, 2, 3});
        assertThat(largestRectangle).isEqualTo(6);
    }

    @Test
    public void should_work_for_test_case_2(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{1, 2, 3, 4, 5});
        assertThat(largestRectangle).isEqualTo(9);
    }

    @Test
    public void should_work_for_test_case_3(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{1, 2, 3, 4, 5, 3, 3, 2});
        assertThat(largestRectangle).isEqualTo(15);
    }

    @Test
    public void should_work_for_test_case_4(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{11, 11, 10, 10, 10});
        assertThat(largestRectangle).isEqualTo(50);
    }

    @Test(timeout = 3000)
    public void should_work_for_test_case_5(){
        String testDataFile = "largestRectangle/testCase8.txt";

        long largestRectangle = LargestRectangle.largestRectangle(buildArrayIntFromFile(testDataFile));

        assertThat(largestRectangle).isEqualTo(12984467);
    }

    private int[] buildArrayIntFromFile(String testDataFile) {

        ArrayList<Integer> numbers = getIntegersInFile(testDataFile);

        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    private ArrayList<Integer> getIntegersInFile(String testDataFile) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = getFileScanner(testDataFile);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineNumbers = line.split(" ");
            for (int i = 0; i < lineNumbers.length; i++) {
                numbers.add(Integer.parseInt(lineNumbers[i]));
            }
        }
        return numbers;
    }

    private Scanner getFileScanner(String testDataFile) {
        URL resource = getClass().getClassLoader().getResource(testDataFile);
        try {
            File file = new File(resource.toURI());
            return new Scanner(file);
        } catch (Exception e) {
            return null;
        }
    }
}