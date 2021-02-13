package CSEN301.Lab4;

import CSEN301.PA4.StackObj;

public class InfixToPostfix {
    static String infixToPostfix(String infix) {
        StackObj stack = new StackObj(infix.length());
        String res = "";
        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);
            if (current >= '0' && current <= '9') {
                res += current;
            } else {
                if (stack.isEmpty()) {
                    stack.push(current);
                } else {
                    switch (current) {
                        case '(':
                             stack.push(current);
                             break;
                        case ')':
                            while ((char) stack.top() != '(') {
                                res += stack.pop();
                            }
                            stack.pop();
                            break;
                        case '+':
                        case '-':
                            while (!stack.isEmpty() && (char) stack.top() != '(') {
                                res += (char) stack.pop();
                            }
                            stack.push(current);
                            break;

                        case '*':
                        case '/':
                            if ((char) stack.top() == '*' || (char) stack.top() == '/') {
                                res += (char) stack.pop();
                            }
                            stack.push(current);
                            break;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            res += (char) stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("(1+2)*(3+4)+(5*6)"));
        System.out.println(infixToPostfix("1+2*3+4"));
    }
}
