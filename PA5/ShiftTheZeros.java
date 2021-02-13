package CSEN301.PA5;

public class ShiftTheZeros {
    static void shiftZeros(QueueObj q) {
        int size = q.size();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if ((int) q.peek() != 0) {
                q.enqueue(q.dequeue());
            } else {
                count++;
                q.dequeue();
            }
        }
        for (int i = 0; i < count; i++) {
            q.enqueue(0);
        }
    }

    public static void main(String[] args) {
        QueueObj qu = new QueueObj(10);
        qu.enqueue(new Integer(5));
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(1));
        qu.enqueue(new Integer(4));
        qu.enqueue(new Integer(3));
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(6));
        qu.enqueue(new Integer(1));
        qu.enqueue(new Integer(0));
        shiftZeros(qu);
        qu.printQueue();
    }
}
