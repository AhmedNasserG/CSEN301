package CSEN301.PA3;

public class StackDecompose {
    public static ArrayStack decompose(ArrayStack x) {
        ArrayStack y = new ArrayStack(x.size() / 2 + x.size() % 2);
        ArrayStack temp = new ArrayStack(x.size());
        while (!x.isEmpty()) {
            temp.push(x.pop());
        }
        if (x.size() % 2 == 0) {
            while (!temp.isEmpty()) {
                y.push(temp.pop());
                if (!temp.isEmpty())
                    x.push(temp.pop());
            }
        } else {
            while (!temp.isEmpty()) {
                x.push(temp.pop());
                if (!temp.isEmpty())
                    y.push(temp.pop());
            }
        }
        return y;
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(8);
        s.push(6);
        s.push(9);
        s.push(3);
        s.push(5);
        s.push(4);
        s.push(1);
        s.push(2);
        s.push(7);
        s.printStack();
        ArrayStack y = decompose(s);
        s.printStack();
        y.printStack();
    }
}
