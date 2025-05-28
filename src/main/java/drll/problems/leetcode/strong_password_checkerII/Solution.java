package drll.problems.leetcode.strong_password_checkerII;

public class Solution {
    public boolean strongPasswordCheckerII(String password) {
        return password.length() >= 8  &&
                containsOneLowerCase(password)  &&
                containsOneUpperCase(password)  &&
                containsOneDigit(password)  &&
                containsOneSpecialCharacter(password)  &&
                notContainsAdjacentEquals(password);
    }

    private boolean notContainsAdjacentEquals(String password) {
        for (int i = 1; i < password.length(); i++) {
            if(password.charAt(i) == password.charAt(i - 1)){
                return false;
            }
        }
        return true;
    }

    private boolean containsOneDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 48  &&  password.charAt(i) <= 57){
                return true;
            }
        }
        return false;
    }

    private boolean containsOneSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()-+";
        for (int i = 0; i < specialCharacters.length(); i++) {
            if(password.indexOf(specialCharacters.charAt(i)) != -1){
                return true;
            }
        }
        return false;
    }

    private boolean containsOneUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 65  &&  password.charAt(i) <= 90){
                return true;
            }
        }
        return false;
    }

    private boolean containsOneLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 97  &&  password.charAt(i) <= 122){
                return true;
            }
        }
        return false;
    }
}