package dsa.catalogueOrder.levelUp.stack.evaluationAndConversion;

import java.util.Stack;

public class PostfixEvaluationAndConversion {

    public static void evaluateAndConvertPostfixExpression(String expression) {
        Stack<Integer> evaluate = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                String prefixVal2 = prefix.pop();
                String prefixVal1 = prefix.pop();
                String prefixEval = ch + prefixVal1 + prefixVal2;
                prefix.push(prefixEval);

                String infixVal2 = infix.pop();
                String infixVal1 = infix.pop();
                String infixEval = "(" + infixVal1 + ch + infixVal2 + ")";
                infix.push(infixEval);

                int val2 = evaluate.pop();
                int val1 = evaluate.pop();
                int postfixEval = calculate(val1, val2, ch);
                evaluate.push(postfixEval);
            } else { // operand
                evaluate.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }
        }
        System.out.println(evaluate.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }

    private static int calculate(int v1, int v2, char operator) {
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
}
