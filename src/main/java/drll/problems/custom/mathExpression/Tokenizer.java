package drll.problems.custom.mathExpression;

public class Tokenizer {
    private final String expression;
    private int index;

    public Tokenizer(String expression) {
        this.expression = sanitize(expression);
    }

    public String nextToken(){

        if(!hasMoreTokens()) return null;

        StringBuilder token = new StringBuilder();
        while (hasMoreTokens()) {
            Character charAt = expression.charAt(index);
            if (Token.isOperator(charAt)) break;
            token.append(charAt);
            index++;
        }

        if(isTokenNotANumber(token)){
            return String.valueOf(expression.charAt(index++));
        }
        return token.toString();
    }

    public boolean hasMoreTokens() {
        return index < expression.length();
    }

    private String sanitize(String expression) {
        return expression.replace(" ", "")
                .replace(",", ".");
    }

    private boolean isTokenNotANumber(StringBuilder token) {
        return token.length() == 0;
    }
}