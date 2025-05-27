package drll.problems.leetcode.count_primes;

import java.util.stream.IntStream;

public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        IntStream.range(2, n).forEach(i -> isPrime[i] = true);
        for (int i = 2; i * i < n; i++) {
            if(isPrime(i)){
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }

        }
        return (int) IntStream.range(0, n).filter(i -> isPrime[i]).count();
    }

    public boolean isPrime(int number){
        if(number == 2  ||  number == 3){
            return true;
        }
        double numberSqrt = Math.sqrt(number);
        if (numberSqrt - (int) numberSqrt == 0){
            return false;
        }
        int jump = 2;
        int eratosthenesPrime = 5;
        while(eratosthenesPrime <= numberSqrt){
            if(number % eratosthenesPrime == 0){
                return false;
            }
            eratosthenesPrime += jump;
            jump = jump == 2 ? 4 : 2;
        }
        return true;
    }
}
