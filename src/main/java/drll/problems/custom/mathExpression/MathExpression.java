package drll.problems.custom.mathExpression;

import java.util.ArrayList;
import java.util.List;

public class MathExpression {
    public List<String> toPrefixNotation(String mathExpression){
        List<String> prefix = new ArrayList<>();

        for (int i = 0; i < mathExpression.length(); i++) {

        }

        return prefix;
    }

    public static class Tokenizer{
        private String expression;
        private int index;

        public Tokenizer(String expression) {
            this.expression = expression.replace(" ", "")
                                        .replace(",", ".");
        }

        public String nextToken(){

            if(!hasMoreTokens()) return null;

            StringBuilder token = new StringBuilder();
            while (hasMoreTokens()) {
                Character charAt = expression.charAt(index);
                if (isOperator(charAt)) break;
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

        private boolean isTokenNotANumber(StringBuilder token) {
            return token.length() == 0;
        }

        private boolean isOperator(Character charAt) {
            return charAt.equals('+')  ||  charAt.equals('-')  ||
                    charAt.equals('*')  ||  charAt.equals('/');
        }
    }
}
