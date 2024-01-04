package dsa.catalogueOrder.levelUp.stack.evaluationAndConversion;

import java.util.Stack;

public class PrefixEvaluationAndConversion {

    public static void evaluateAndConvertPrefixExpression(String expression) {
        Stack<Integer> evaluate = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                String postfixVal1 = postfix.pop();
                String postfixVal2 = postfix.pop();
                String postfixEval = postfixVal1 + postfixVal2 + ch;
                postfix.push(postfixEval);

                String infixVal1 = infix.pop();
                String infixVal2 = infix.pop();
                String infixEval = "(" + infixVal1 + ch + infixVal2 + ")";
                infix.push(infixEval);

                int val1 = evaluate.pop();
                int val2 = evaluate.pop();
                int prefixEval = calculate(val1, val2, ch);
                evaluate.push(prefixEval);
            } else { // operand
                evaluate.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            }
        }

        System.out.println(evaluate.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
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
