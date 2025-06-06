
package drll.problems.hacker_rank.k_factorization;

import java.io.*;
import java.util.*;

public class KFactorization {

    // Complete the kFactorization function below.
    static int[] kFactorization(int n, int[] A) {

        Arrays.sort(A);

        if(Arrays.binarySearch(A, n) > 0){
            return new int[]{1, n};
        }

        List<Integer> utilNumbers = new ArrayList<>();

        for (int i = A[0] == 1 ?1 :0; i < A.length  &&  A[i] <= n; i++) {
            if(n % A[i] == 0){
                utilNumbers.add(A[i]);
            }
        }

        if(utilNumbers.isEmpty()){
            return new int[]{-1};
        }

        int[][] nDecomposition = factorDecomposition(n);
        List<Integer> targetFactor = getTargetFactors(nDecomposition);

        int[] lessCombinationOfFactors = findLessFactorCombination(n, targetFactor, utilNumbers);
        if(lessCombinationOfFactors == null){
            return new int[]{-1};
        }

        Arrays.sort(lessCombinationOfFactors);

        int[] result = new int[lessCombinationOfFactors.length + 1];
        result[0] = 1;

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * lessCombinationOfFactors[i - 1];
        }

        return result;
    }

    private static List<Integer> getTargetFactors(int[][] nDecomposition) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 0; i < nDecomposition[0].length; i++) {
            factors.add((int) Math.pow(nDecomposition[0][i], nDecomposition[1][i]));
        }
        return factors;
    }

    private static int[] findLessFactorCombination(int n, List<Integer> targetFactors,
                                                   List<Integer> utilNumbers) {

        int[] candidate = convertToIntArray(targetFactors);
        if(findNumber(candidate, convertToIntArray(utilNumbers))){
            return candidate;
        }

        LinkedList<Integer> combination = new LinkedList<>();
        if(findCombination(n, utilNumbers, combination, utilNumbers.size() - 1)) {
            int[] result = new int[combination.size()];
            int i = result.length - 1;
            while (!combination.isEmpty()) {
                result[i--] = combination.pop();
            }
            return result;
        }
        return null;
    }

    private static boolean findCombination(int n, List<Integer> utilNumbers, LinkedList<Integer> combination, int end) {
        if (n == 1){
            return true;
        }
        for (int i = end; i >= 0; i--) {
            if(n % utilNumbers.get(i) != 0){
                continue;
            }
            combination.push(utilNumbers.get(i));
            if(findCombination(n / utilNumbers.get(i), utilNumbers, combination, end)){
                return true;
            }
            combination.pop();
        }
        return false;
    }

    static boolean findNumber(int[] numbers, int[] target){
        for (int number : numbers) {
            if (Arrays.binarySearch(target, number) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * result[0] factors
     * result[1] exponents
     * @param number
     * @return
     */
    private static int[][] factorDecomposition(int number){

        List<Integer> factor = new ArrayList<>();
        List<Integer> exponent = new ArrayList<>();
        PrimeIterator primeIterator = new PrimeIterator();

        while (number != 1) {
            if(primeIterator.isPrime(number)){
                factor.add(number);
                exponent.add(1);
                break;
            }
            int currentPrime = primeIterator.currentPrimeNumber();
            if (number % currentPrime == 0) {
                int index = factor.indexOf(currentPrime);
                if (index == -1) {
                    factor.add(currentPrime);
                    exponent.add(1);
                } else {
                    exponent.set(index, exponent.get(index) + 1);
                }
                number = number / currentPrime;
            } else {
                primeIterator.nextPrimeNumber();
            }
        }
        int[][] decomposition = new int[2][factor.size()];
        for (int i = 0; i < factor.size(); i++) {
            decomposition[0][i] = factor.get(i);
            decomposition[1][i] = exponent.get(i);
        }
        return decomposition;
    }

    private static int[] convertToIntArray(List<Integer> cumulativeSolution) {
        if(cumulativeSolution == null){
            return null;
        }
        int[] result = new int[cumulativeSolution.size()];

        for (int i = 0; i < cumulativeSolution.size(); i++) {
            result[i] = cumulativeSolution.get(i);
        }

        return result;
    }
}