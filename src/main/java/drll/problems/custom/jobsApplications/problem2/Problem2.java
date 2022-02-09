package drll.problems.custom.jobsApplications.problem2;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static List<Integer> findValidDiscountCoupons(List<String> discounts) {
        List<Integer> validation = new ArrayList<>();

        for (String discount : discounts) {
            if (isFormedByValidDiscounts(discount)) {
                validation.add(1);
            } else {
                validation.add(0);
            }
        }

        return validation;
    }

    private static boolean isFormedByValidDiscounts(String discount) {
        if(isPalindrome(discount)){
            return true;
        }
        if(discount.length() == 2){
            return false;
        }
        if(discount.charAt(0) == discount.charAt(discount.length() - 1)){
            return isFormedByValidDiscounts(discount.substring(1, discount.length() - 1));
        }
        else {
            for (int i = 2; i < discount.length() - 1; i++) {
                String leftPart = discount.substring(0, i);
                String rightPart = discount.substring(i);

                boolean isValidLeft = isFormedByValidDiscounts(leftPart);
                boolean isValidRight = isFormedByValidDiscounts(rightPart);

                if(isValidLeft && isValidRight){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPalindrome(String word){
        return isPalindrome(word, 0, word.length() - 1);
    }

    private static boolean isPalindrome(String word, int init, int end){
        if(init > end){
            return true;
        }
        if(word.charAt(init) != (word.charAt(end))){
            return false;
        }
        return isPalindrome(word, init + 1, end - 1);
    }
}