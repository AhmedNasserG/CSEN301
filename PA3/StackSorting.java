package CSEN301.PA3;

public class StackSorting {
    public static void stackSort(ArrayStack stack) {
        ArrayStack temp = new ArrayStack(stack.size());
        int numOfUnsorted = stack.size();
        while (numOfUnsorted > 0) {
            int min = stack.top();
            int count = 0;
            int j = 0;
            while (j < numOfUnsorted) {
                int current = stack.pop();
                if (min > current) {
                    min = current;
                    count = 1;
                } else if (min == current) {
                    count++;
                }
                temp.push(current);
                j++;
            }
            numOfUnsorted -= count;
            for (int i = 0; i < count; i++) {
                stack.push(min);
            }
            while (!temp.isEmpty()) {
                int current = temp.pop();
                if (current != min) {
                    stack.push(current);
                }
            }
        }
    }

    public static void StackSort(ArrayStack stack) {
        int count = stack.size();
        ArrayStack temp = new ArrayStack(count);
        while (count > 0) {
            int min = stack.pop();
            for (int i = 1; i < count; i++) {
                int current = stack.pop();
                if (min > current) {
                    temp.push(min);
                    min = current;
                } else {
                    temp.push(current);
                }
            }
            temp.push(min);
            count--;
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
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
        StackSort(s);
        s.printStack();
    }
}
