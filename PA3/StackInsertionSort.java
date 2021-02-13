package CSEN301.PA3;

public class StackInsertionSort {
    static void stackSort(ArrayStack s) {
        int size = s.size();
        ArrayStack temp = new ArrayStack(size);
        ArrayStack sorted = new ArrayStack(size);
        for (int i = 0; i < size; i++) {
            int current = s.pop();
            while (!sorted.isEmpty() && sorted.top() < current) {
                temp.push(sorted.pop());
            }
            sorted.push(current);
            while (!temp.isEmpty()) {
                sorted.push(temp.pop());
            }
        }
        while (!sorted.isEmpty()) {
            s.push(sorted.pop());
        }
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(4);
        s.push(1);
        s.push(4);
        s.push(3);
        s.push(2);
        s.printStack();
        stackSort(s);
        s.printStack();
    }
}
