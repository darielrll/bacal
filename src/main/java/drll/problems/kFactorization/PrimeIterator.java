
package drll.problems.kFactorization;

import java.util.ArrayList;
import java.util.List;

public class PrimeIterator{

    private List<Integer> primeNumbers;
    private int currentIndex;
    private int incToFindNextCandidate;

    public PrimeIterator() {
        primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);

        init();
    }

    public long nextPrimeNumber(){
        if (currentIndex == 0  ||  primeNumbers.size() < currentIndex + 1){
            currentIndex++;
            return currentPrimeNumber();
        }
        int nextPrimeCandidate = currentPrimeNumber() + 2;
        while (!isPrime(nextPrimeCandidate)){
            nextPrimeCandidate += 2;
        }
        primeNumbers.add(nextPrimeCandidate);
        currentIndex++;
        return currentPrimeNumber();
    }

    public int currentPrimeNumber(){
        return primeNumbers.get(currentIndex);
    }

    public void reset(){
        init();
    }

    public boolean isPrime(int number){
        if(number == 2  ||  number == 3){
            return true;
        }
        if(number % 2 == 0  ||  number % 3 == 0){
            return false;
        }
        Double sqrt = Math.sqrt(number);
        if (sqrt - sqrt.intValue() == 0){
            return false;
        }
        int nextCandidatePosition = 2;
        sqrt += 1;
        int i = 5;
        while(i <= sqrt){
            if(number % i == 0){
                return false;
            }
            i += nextCandidatePosition;
            if(nextCandidatePosition == 2){
                nextCandidatePosition = 4;
            }
            else {
                nextCandidatePosition = 2;
            }
        }
        return true;
    }

    private void init(){
        currentIndex = 0;
        incToFindNextCandidate = 2;
    }
}