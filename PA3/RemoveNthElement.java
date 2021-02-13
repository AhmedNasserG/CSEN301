package CSEN301.PA3;

public class RemoveNthElement {
    static void removeNth(ArrayStack s, int n) {
        ArrayStack temp = new ArrayStack(s.size());
        int index = s.size();
        while (!s.isEmpty()) {
            if (index == n) {
                s.pop();
                break;
            }
            temp.push(s.pop());
            index--;
        }
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(5);
        s.push(1);
        s.push(5);
        s.push(23);
        s.push(8);
        s.push(2);
        s.printStack();
        removeNth(s, 3);
        s.printStack();
    }
}
