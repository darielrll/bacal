package drll.problems.leetcode.superPalindromes;

import java.util.Iterator;

public class PalindromeNumberPar implements Iterator<Integer> {
    private int currentValue;
    private int factorGrowth;
    private int digitsNumber;
    private boolean endIterator;

    public PalindromeNumberPar(int digitsNumber) {
        if(digitsNumber % 2 != 0){
            throw new IllegalArgumentException("Init parameter should be par");
        }
        this.digitsNumber = digitsNumber;
        factorGrowth = (int) Math.pow(10, (digitsNumber >> 1) - 1);
        endIterator = false;
    }

    @Override
    public boolean hasNext() {
        if(currentValue == 0){
            return true;
        }
        String currentString = String.valueOf(currentValue);
        return !currentString.replaceAll("9", "").equals("");
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            String factorGrowthString = String.valueOf(factorGrowth);
            currentValue = Integer.parseInt(factorGrowthString.concat(new StringBuilder(factorGrowthString).reverse().toString()));
            factorGrowth++;
            return currentValue;
        }
        return null;
    }
}
