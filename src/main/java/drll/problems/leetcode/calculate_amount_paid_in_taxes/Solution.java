package drll.problems.leetcode.calculate_amount_paid_in_taxes;

public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        if(income == 0){
            return 0;
        }

        double tax = Math.min(income, brackets[0][0]) * brackets[0][1] / 100.0;

        int pendingIncome = income - Math.min(income, brackets[0][0]);
        for (int i = 1; i < brackets.length  && pendingIncome > 0; i++) {
            int currentUpperBound = brackets[i][0];
            int previousUpperBound = brackets[i - 1][0];
            int currentTaxRatePercent = brackets[i][1];

            int currentDollarEarned = Math.min(income, currentUpperBound) - previousUpperBound;

            tax += currentDollarEarned * currentTaxRatePercent / 100.0;

            pendingIncome -= currentDollarEarned;
        }

        return tax;
    }
}