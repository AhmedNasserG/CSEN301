package CSEN301.PA5;

import CSEN301.PA4.StackObj;

public class EveryThirdElement {
    static QueueObj ETE(QueueObj q) {
        StackObj stack = new StackObj(q.size());
        while (!q.isEmpty()) {
            stack.push(q.dequeue());
        }
        int count = 0;
        while (!stack.isEmpty()) {
            if (count++ % 3 == 0) {
                q.enqueue(stack.pop());
            } else {
                stack.pop();
            }
        }
        return q;
    }

    public static void main(String[] args) {
        QueueObj q = new QueueObj(10);
        q.enqueue(new Character('a'));
        q.enqueue(new Character('b'));
        q.enqueue(new Character('c'));
        q.enqueue(new Character('d'));
        q.enqueue(new Character('e'));
        q.enqueue(new Character('f'));
        q.enqueue(new Character('g'));
        q.enqueue(new Character('h'));
        q.enqueue(new Character('i'));
        q.enqueue(new Character('j'));
        QueueObj ans = ETE(q);
        ans.printQueue();
    }
}
