package CSEN301.PA4;

public class InfixToPostfix {
    static String infixToPostfix(String infix) {
        String res = "";
        StackObj stack = new StackObj(infix.length());
        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);
            if (current >= '0' && current <= '9') {
                res += current;
            } else {
                if (stack.isEmpty()) {
                    stack.push(current);
                } else {
                    switch (current) {
                        case '+':
                        case '-':
                            while (!stack.isEmpty()) {
                                res += (char) stack.pop();
                            }
                            stack.push(current);
                            break;
                        case '*':
                        case '/':
                            if ((char) stack.top() == '*') {
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
        System.out.println(infixToPostfix("1+2*3+4+3*9*7+8"));
    }
}
