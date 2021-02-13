package CSEN301.PA8;

public class QueueUsingLinkedList {
    DoublyLinkedList l ;
    int count;
    public QueueUsingLinkedList(){
        l = new DoublyLinkedList();
        count = 0;
    }
    // O(1)
    public void enqueue(Object o){
        l.insertLast(o);
        count++;
    }
    // O(1)
    public Object dequeue(){
        count--;
        return l.removeFirst();
    }
    // O(1)
    public Object peek(){
        Object temp = l.removeFirst();
        l.insertFirst(temp);
        return temp;
    }
    // O(1)
    public boolean isEmpty(){
        return l.isEmpty();
    }
    // O(1)
    public int size(){
        return count;
    }
}
