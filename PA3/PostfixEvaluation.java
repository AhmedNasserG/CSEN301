package CSEN301.PA3;

public class PostfixEvaluation {
    public static int evaluate(String s) {
        String[] arr = s.split(" ");
        ArrayStack stack = new ArrayStack(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (arr[i].equals("-")) {
                stack.push(-1 * stack.pop() + stack.pop());
            } else if (arr[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (arr[i].equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 / op2);
            } else {
                stack.push(Integer.parseInt(arr[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr0 = "8 4 /";
        System.out.println(expr0 + "=" + evaluate(expr0));
        String expr1 = "1 2 3 * + 4 +";
        System.out.println(expr1 + "" +
                "=" + evaluate(expr1));
    }
}
