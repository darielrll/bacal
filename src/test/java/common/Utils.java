
package common;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static int[] buildTestCasesForAnOrderedList(boolean asc, int number){
        return buildTestCasesForAnOrderedList(asc, 0, number);
    }

    public static int[] buildTestCasesForAnOrderedList(boolean asc, int init, int end){
        if(end <= init){
            throw new IllegalArgumentException("End value should be greater than init value");
        }
        int[] result = new int[end - init];

        if(asc) {
            for (int i = 0; i < end; i++) {
                result[i] = init + i + 1;
            }
        }
        else {
            for (int i = 0; i < end - init; i++) {
                result[i] = end - i;
            }
        }

        return result;
    }

    public static Integer[] buildTestCasesForARandomList(boolean admitEquals, int number, int length){
        if(!admitEquals  &&  number <= length){
            throw new IllegalArgumentException("If no admit equal numbers then number must be greater than length");
        }
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        do{
            int value = random.nextInt(number) + 1;
            if(!admitEquals){
                while (list.contains(value)){
                    value = random.nextInt(number) + 1;
                }
            }
            list.add(value);
        }
        while (--length > 0);

        return list.toArray(new Integer[0]);
    }

    public static int[] mergeArrays(int[] firstList, int[] secondList) {
        if(firstList.length != secondList.length){
            throw new IllegalArgumentException("Arrays should have the same length");
        }

        int[] result = new int[firstList.length + secondList.length];

        for (int i = 0; i < firstList.length; i++){
            result[i * 2] = firstList[i];
            result[i * 2 + 1] = secondList[i];
        }

        return result;
    }

    public static int[] buildTestCasesForVeryLongEntries(String ... partsOfSameEntry){

        List<String[]> cases = new ArrayList<>();
        for (String s : partsOfSameEntry) {
            cases.add(s.split(" "));
        }

        List<Integer> numbers = new ArrayList<>();
        for (String[] testCaseSplit : cases) {
            for (String s : testCaseSplit) {
                numbers.add(Integer.parseInt(s));
            }
        }
        int[] result = new int[numbers.size()];
        Integer[] integers = numbers.toArray(new Integer[0]);
        for (int i  = 0; i < integers.length; i++){
            result[i] = integers[i];
        }
        return result;
    }

    public static Scanner getFileScanner(String testDataFile) {
        URL resource = Utils.class.getClassLoader().getResource(testDataFile);
        try {
            File file = new File(resource.toURI());
            return new Scanner(file);
        } catch (Exception e) {
            return null;
        }
    }

    public static int[] buildArrayIntFromFile(String testDataFile) {
        return buildArrayIntFromFile(testDataFile, " ");
    }

    public static int[] buildArrayIntFromFile(String testDataFile, String separator) {

        ArrayList<Integer> numbers = getIntegersInFile(testDataFile, separator);

        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    private static ArrayList<Integer> getIntegersInFile(String testDataFile, String separator) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = getFileScanner(testDataFile);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineNumbers = line.split(separator);
            for (String lineNumber : lineNumbers) {
                numbers.add(Integer.parseInt(lineNumber));
            }
        }
        return numbers;
    }

    public static int[][] getIntegersListInFile(String testDataFile) {
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        Scanner sc = getFileScanner(testDataFile);

        while (sc.hasNextLine()) {
            ArrayList<Integer> numberList = new ArrayList<>();
            String line = sc.nextLine();
            line = line.substring(1, line.length() - 1);
            String[] lineNumbers = line.split(",");
            for (String lineNumber : lineNumbers) {
                numberList.add(Integer.parseInt(lineNumber));
            }
            numbers.add(numberList);
        }

        int[][] result = new int[numbers.size()][];
        for (int i = 0; i < numbers.size(); i++) {
            int[] tmp = new int[numbers.get(i).size()];
            for (int j = 0; j < numbers.get(i).size(); j++) {
                tmp[j] = numbers.get(i).get(j);
            }
            result[i] = tmp;
        }
        return result;
    }
}