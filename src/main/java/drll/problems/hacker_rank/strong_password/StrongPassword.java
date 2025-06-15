
package drll.problems.hacker_rank.strong_password;

public class StrongPassword {

    private StrongPassword() { }

    public static int minimumNumber(int length, String password) {

        if (length <= 2) {
            return 6 - length;
        }

        int result = 0;
        if (!containNumbers(password)) {
            result++;
        }

        if (!containsLowerCase(password)) {
            result++;
        }

        if (!containsUpperCase(password)) {
            result++;
        }

        if (!containsSpecialCharacter(password)) {
            result++;
        }

        return length + result < 6
                ? 6 - length
                : result;
    }

    private static boolean containsSpecialCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(c == '!'  || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' ||
               c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' ||
               c == 'F' || c == 'G' || c == 'H' || c == 'I' || c == 'J' ||
               c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'O' ||
               c == 'P' || c == 'Q' || c == 'R' || c == 'S' || c == 'T' ||
               c == 'U' || c == 'V' || c == 'W' || c == 'X' || c == 'Y' ||
               c == 'Z') {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' ||
               c == 'f' || c == 'g' || c == 'h' || c == 'i' || c == 'j' ||
               c == 'k' || c == 'l' || c == 'm' || c == 'n' || c == 'o' ||
               c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' ||
               c == 'u' || c == 'v' || c == 'w' || c == 'x' || c == 'y' ||
               c == 'z') {
                return true;
            }
        }
        return false;
    }

    private static boolean containNumbers(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
               c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                return true;
            }
        }
        return false;
    }
}
