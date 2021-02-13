package CSEN301.PA5;

public class MirrorUsingQueues {
    static QueueObj mirror(QueueObj q) {
        int size = q.size();
        QueueObj res = new QueueObj(size * 2);
        // get the reverse of the queue
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                q.enqueue(q.dequeue());
            }
            res.enqueue(q.peek());
        }

        for (int i = 0; i < size; i++) {
            res.enqueue(q.dequeue());
        }
        return res;
    }

    public static void main(String[] args) {
        QueueObj q = new QueueObj(5);
        q.enqueue(new Integer(1));
        q.enqueue(new Integer(8));
        q.enqueue(new Integer(15));
        q.enqueue(new Integer(7));
        q.enqueue(new Integer(2));
        q.printQueue();
        QueueObj mirrorQ = mirror(q);
        mirrorQ.printQueue();
    }
}
