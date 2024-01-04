package dsa.catalogueOrder.levelUp.stack.evaluationAndConversion;

import java.util.Stack;

public class InfixConversions {

    public static void conversions(String expression) {
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch) || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                prefix.push(ch + "");
                postfix.push(ch + "");
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    String preVal2 = prefix.pop();
                    String preVal1 = prefix.pop();

                    String postVal2 = postfix.pop();
                    String postVal1 = postfix.pop();

                    char operator = operators.pop();

                    String pre_evaluate = operator + preVal1 + preVal2;
                    prefix.push(pre_evaluate);
                    
                    String post_evaluate = postVal1 + postVal2 + operator;
                    postfix.push(post_evaluate);
                }
                operators.pop(); // for removing '(' from the top
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                while (operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    String preVal2 = prefix.pop();
                    String preVal1 = prefix.pop();

                    String postVal2 = postfix.pop();
                    String postVal1 = postfix.pop();

                    char operator = operators.pop();

                    String pre_evaluate = operator + preVal1 + preVal2;
                    prefix.push(pre_evaluate);

                    String post_evaluate = postVal1 + postVal2 + operator;
                    postfix.push(post_evaluate);
                }
                operators.push(ch);
            }
        }

        while (operators.size() > 0) {
            char operator = operators.pop();

            String preVal2 = prefix.pop();
            String preVal1 = prefix.pop();

            String pre_evaluate = operator + preVal1 + preVal2;
            prefix.push(pre_evaluate);

            String postVal2 = postfix.pop();
            String postVal1 = postfix.pop();

            String post_evaluate = postVal1 + postVal2 + operator;
            postfix.push(post_evaluate);
        }

        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
    }

    private static int precedence(char operator) {
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
