package CSEN301.PA5;

import CSEN301.PA4.StackObj;

public class QueueUsingStacks {
    private StackObj stack, temp;
    private int maxSize;

    public QueueUsingStacks(int maxSize) {
        this.maxSize = maxSize;
        stack = new StackObj(maxSize);
        temp = new StackObj(maxSize);
    }

    public void enqueue(Object o) {
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(o);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    public Object dequeue(){
        return stack.pop();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public boolean isFull(){
        return stack.isFull();
    }
    public int size(){
        return stack.size();
    }
}
