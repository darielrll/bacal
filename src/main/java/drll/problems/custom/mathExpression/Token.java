package drll.problems.custom.mathExpression;

public class Token {
    public static boolean isOperator(Character operator) {
        return isOperator(operator.toString());
    }

    public static boolean isOperator(String operator) {
        return operator.equals("+")  ||  operator.equals("-")  ||
                operator.equals("*")  ||  operator.equals("/");
    }
}