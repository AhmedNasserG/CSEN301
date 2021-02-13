package CSEN301.Other;

import CSEN301.PA3.ArrayStack;
import CSEN301.PA4.StackObj;
import CSEN301.PA5.QueueObj;

public class Scramble {
    public static void scramble(QueueObj q){
        int count = 1;
        int i = 0;
        int size = q.size();;
        while (i < size) {
            if (count % 2 == 0) {
                StackObj s = new StackObj(count);
                for (int j = 0; j < count && i < size; j++){
                    s.push(q.dequeue());
                    i++;
                }
                while (!s.isEmpty()) {
                    q.enqueue(s.pop());
                }
            } else {
                for (int j = 0; j < count && i < size; j++) {
                    q.enqueue(q.dequeue());
                    i++;
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        QueueObj q = new QueueObj(17);
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(14);
        q.enqueue(15);
        q.enqueue(16);
        scramble(q);
        for (int i = 0; i < 17; i++) {
            System.out.print((int) q.dequeue() + " ");

        }
    }
}
