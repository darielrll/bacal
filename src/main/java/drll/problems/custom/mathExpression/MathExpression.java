package drll.problems.custom.mathExpression;

import java.util.*;

public class MathExpression {
    public List<String> toPostfixNotation(String mathExpression) throws Exception{
        List<String> prefix = new ArrayList<>();
        Deque<String> operatorsStack = new ArrayDeque<>();
        Tokenizer tokenizer = new Tokenizer(mathExpression);

        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if(Token.isOperator(token)){
                prefix.addAll(extractPriorityOperators(token, operatorsStack));
                operatorsStack.push(token);
            }
            else{
                prefix.add(token);
            }
        }

        while (!operatorsStack.isEmpty()){
            prefix.add(operatorsStack.pop());
        }

        return prefix;
    }

    private List<String> extractPriorityOperators(String operator, Deque<String> operatorsStack) throws Exception{
        List<String> priorityOperators = new ArrayList<>();

        while (!operatorsStack.isEmpty()  &&  hasPriority(operatorsStack.peek(), operator)){
            priorityOperators.add(operatorsStack.pop());
        }

        return priorityOperators;
    }

    private boolean hasPriority(String source, String target) throws Exception {
        return priorityLevel(source) >= priorityLevel(target);
    }

    private int priorityLevel(String operator) throws Exception {
        switch (operator){
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            default:
                throw new Exception("Unknow operator");
        }
    }

    public static class Token{
        public static boolean isOperator(Character operator) {
            return isOperator(operator.toString());
        }

        public static boolean isOperator(String operator) {
            return operator.equals("+")  ||  operator.equals("-")  ||
                    operator.equals("*")  ||  operator.equals("/");
        }
    }

    public static class Tokenizer{
        private String expression;
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
}
