package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class InfixExpressions {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String expression = s.nextLine();
//        System.out.println(infixEvaluation(expression));
        infixConversions(expression);
    }

    private static int priority(char operator) {
        if (operator == '/' || operator == '*') return 2;
        else if (operator == '+' || operator == '-') return 1;
        else return 0;
    }

    private static int evaluate(int val1, int val2, char operator) {
        if (operator == '*') {
            return val1 * val2;
        } else if (operator == '/') {
            return val1 / val2;
        } else if (operator == '+') {
            return val1 + val2;
        } else if (operator == '-') {
            return val1 - val2;
        } else {
            return 0;
        }
    }

    private static int infixEvaluation(String s) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (ch >= '0' && ch <= '9') { // assuming all the operands/values are single digit;
                operandStack.push((int) (ch - '0'));
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    int val2 = operandStack.pop();
                    int val1 = operandStack.pop();
                    char op = operatorStack.pop();

                    int res = evaluate(val1, val2, op);
                    operandStack.push(res);
                }
                operatorStack.pop(); // pop the '('
            } else {
                // current character is an operator
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(' && priority(operatorStack.peek()) >= priority(ch)) {
                    int val2 = operandStack.pop();
                    int val1 = operandStack.pop();
                    char op = operatorStack.pop();

                    int res = evaluate(val1, val2, op);
                    operandStack.push(res);
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            int val2 = operandStack.pop();
            int val1 = operandStack.pop();
            char op = operatorStack.pop();

            int res = evaluate(val1, val2, op);
            operandStack.push(res);
        }
        return operandStack.peek();
    }

    // s is an infix expression -> given
    private static void infixConversions(String s) {
        Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                operator.push(c);
            } else if ((c >= '0' &&  c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                pre.push(c + "");
                post.push(c + "");
            } else if (c == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    char opt = operator.pop();

                    String postVal2 = post.pop();
                    String postVal1 = post.pop();
                    post.push(postVal1 + postVal2 + opt);

                    String preVal2 = pre.pop();
                    String preVal1 = pre.pop();
                    pre.push(opt + preVal1 + preVal2);
                }
                operator.pop();
            } else if (c == '*' || c == '+' || c == '-' || c == '/') {
                while (!operator.isEmpty() && operator.peek() != '(' && priority(operator.peek()) >= priority(c)) {
                    char opt = operator.pop();

                    String postVal2 = post.pop();
                    String postVal1 = post.pop();
                    post.push(postVal1 + postVal2 + opt);

                    String preVal2 = pre.pop();
                    String preVal1 = pre.pop();
                    pre.push(opt + preVal1 + preVal2);
                }
                operator.push(c);
            }
        }

        while (!operator.isEmpty()) {
            char opt = operator.pop();

            String postVal2 = post.pop();
            String postVal1 = post.pop();
            post.push(postVal1 + postVal2 + opt);

            String preVal2 = pre.pop();
            String preVal1 = pre.pop();
            pre.push(opt + preVal1 + preVal2);
        }

        System.out.println(post.peek());
        System.out.println(pre.peek());
    }
}
