
package drll.problems.hackerRank.strongPassword;

public class StrongPassword {

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
            switch (password.charAt(i)) {
                case '!':
                case '@':
                case '#':
                case '$':
                case '%':
                case '^':
                case '&':
                case '*':
                case '(':
                case ')':
                case '-':
                case '+':
                    return true;
            }
        }
        return false;
    }

    private static boolean containsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            switch (password.charAt(i)) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            switch (password.charAt(i)) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    return true;
            }
        }

        return false;
    }

    private static boolean containNumbers(String password) {
        for (int i = 0; i < password.length(); i++) {
            switch (password.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return true;
            }
        }

        return false;
    }
}
