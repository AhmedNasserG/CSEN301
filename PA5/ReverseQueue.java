package CSEN301.PA5;

import CSEN301.PA4.StackObj;

public class ReverseQueue {
    //reverse using stacks
    static void reverse(QueueObj queue) {
        StackObj stack = new StackObj(queue.size());
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }

    //reverse using stacks
    static QueueObj reverse2(QueueObj queue) {
        QueueObj reversed = new QueueObj(queue.size());
        for (int i = 0; i < queue.size(); i++) {
            for (int j = 0; j < queue.size() - 1; j++) {
                queue.enqueue(queue.dequeue());
            }
            reversed.enqueue(queue.peek());
        }
        return reversed;
    }

    //reverse using recursion
    static QueueObj reverseRec(QueueObj queue) {
        if (queue.isEmpty()) {
            return queue;
        }
        Object current = queue.dequeue();
        queue = reverseRec(queue);
        queue.enqueue(current);
        return queue;
    }

    //reverse in place without any extra ADT
    public static void ReverseIter(QueueObj q) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Object curr = q.dequeue();
            for (int j = 0; j < size - 1 - i; j++) {
                q.enqueue(q.dequeue());
            }
            q.enqueue(curr);
            for (int j = 0; j < i; j++) {
                q.enqueue(q.dequeue());
            }
        }
    }

}
