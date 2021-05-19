package drll.problems.custom.mathExpression;

import java.util.*;

public class MathExpression {
    public double evalMathExpression(String mathExpression) throws Exception {
        List<String> postfixNotation = toPostfixNotation(mathExpression);
        LinkedList<Double> accumulativeResult = new LinkedList<>();

        for (String s : postfixNotation) {
            if (Token.isOperator(s)) {
                Double rightOperand = accumulativeResult.pop();
                Double leftOperand = accumulativeResult.pop();
                accumulativeResult.push(calculate(leftOperand, s, rightOperand));
            } else {
                accumulativeResult.push(Double.parseDouble(s));
            }
        }
        return Math.round(accumulativeResult.pop() * 100) / 100.0;
    }

    private Double calculate(Double leftOperand, String operator, Double rightOperand) throws Exception {
        switch (operator){
            case "-":
                return leftOperand - rightOperand;
            case "+":
                return leftOperand + rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
            default:
                throw new Exception("Not supported operation");
        }
    }

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
                throw new Exception("Unknown operator");
        }
    }
}
