package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class PostfixExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> evaluation = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                infix.push(c+"");
                prefix.push(c+"");
                evaluation.push((int)(c - '0'));
            } else {
                if(c == '+') {
                    int val2 = evaluation.pop();
                    int val1 = evaluation.pop();
                    evaluation.push(val1 + val2);
                } else if(c == '-') {
                    int val2 = evaluation.pop();
                    int val1 = evaluation.pop();
                    evaluation.push(val1 - val2);
                } else if(c == '*') {
                    int val2 = evaluation.pop();
                    int val1 = evaluation.pop();
                    evaluation.push(val1 * val2);
                } else if(c == '/') {
                    int val2 = evaluation.pop();
                    int val1 = evaluation.pop();
                    evaluation.push(val1 / val2);
                }

                String infixVal2 = infix.pop();
                String infixVal1 = infix.pop();
                infix.push("(" + infixVal1 + c + infixVal2 + ")");

                String prefixVal2 = prefix.pop();
                String prefixVal1 = prefix.pop();
                prefix.push(c + prefixVal1 + prefixVal2);
            }
        }

        System.out.println(evaluation.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
    }
}
