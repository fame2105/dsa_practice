package dsa.catalogueOrder.levelUp.stack.evaluationAndConversion;

import java.util.Stack;

public class InfixEvaluation {

    public int infixEvaluation(String expression) {

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    char operator = operators.pop();

                    int evaluate = calculate(v1, v2, operator);
                    operands.push(evaluate);
                }
                operators.pop(); // for removing '(' from the top
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                while (operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    char operator = operators.pop();

                    int evaluate = calculate(v1, v2, operator);
                    operands.push(evaluate);
                }
                operators.push(ch);
            }
        }

        while (operators.size() > 0 && operators.peek() != '(') {
            int v2 = operands.pop();
            int v1 = operands.pop();

            char operator = operators.pop();

            int evaluate = calculate(v1, v2, operator);
            operands.push(evaluate);
        }

        return operands.pop();
    }

    private int calculate(int v1, int v2, char operator) {
        if (operator == '+') {
            return v1 + v2;
        } else if (operator == '-') {
            return v1 - v2;
        } else if (operator == '/') {
            return v1 / v2;
        } else {
            return v1 * v2;
        }
    }

    private int precedence(char operator) {
        if (operator == '+') {
            return 1;
        } else if (operator == '-') {
            return 1;
        } else if (operator == '/') {
            return 2;
        } else {
            return 2;
        }
    }
}
