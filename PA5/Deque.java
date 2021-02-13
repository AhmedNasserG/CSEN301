package CSEN301.PA5;

public class Deque {
    static Object[] arr;
    private final int maxSize;
    private int front;
    private int rear;

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        arr = new Object[maxSize];
        front = 0;
        rear = 0;
    }

    public int size() {
        return rear - front;
    }

     int getIndex(int i) {
        return (arr.length + (i % arr.length)) % arr.length;
    }

    public void insertFirst(Object o) {
        if (size() == maxSize) {
            System.out.println("sorry deque is full");
            return;
        }
        arr[getIndex(--front)] = o;
    }

    public void insertLast(Object o) {
        if (size() == maxSize) {
            System.out.println("sorry deque is full");
            return;
        }
        arr[getIndex(rear++)] = o;
    }

    public Object removeFirst() {
        return arr[getIndex(front++)];
    }

    public Object removeLast() {
        return arr[getIndex(--rear)];
    }

    public Object peekFront() {
        return arr[getIndex(front)];
    }

    public Object peekRear() {
        return arr[getIndex(rear - 1)];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == maxSize;
    }


    public static void main(String[] args) {
        Deque d = new Deque(5);
        d.insertFirst(3);
        d.insertFirst(2);
        d.insertFirst(1);
        d.insertLast(4);
        d.insertLast(5);
        for (Object  i : arr) {
            System.out.print(((Integer) i) + " ");
        }
        System.out.println();
        System.out.println(d.isFull());
        System.out.println(d.removeFirst());
        System.out.println(d.removeLast());
        System.out.println(d.peekFront());
        System.out.println(d.isEmpty());
        System.out.println(d.isFull());
    }
}
