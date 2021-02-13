package CSEN301.PA8;

public class CircularLinkedList {
    Link head;
    Link last;

    public CircularLinkedList() {
        head = null;
        last = null;
    }

    public void insertFirst(Object o) {
        Link l = new Link(o);
        if (head == null) {
            last = l;
        }
        l.next = head;
        head = l;
        last.next = head;
    }

    public void insertLast(Object o) {
        Link l = new Link(o);
        if (head == null) {
            last = l;
            head = l;
        }
        last.next = l;
        last = l;
        last.next = head;
    }

    public Object removeFirst() {
        Object res = head.data;
        if (head.next == head) {
            head = null;
            last = null;
            return res;
        }
        head = head.next;
        last.next = head;
        return res;
    }

    public Object removeLast() {
        Object res = last.data;
        if (head.next == head) {
            head = null;
            last = null;
            return res;
        }
        Link current = head;
        while (current.next != last) {
            current = current.next;
        }
        current.next = head;
        last = current;
        return res;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        String res = "[";
        if (!isEmpty()) {
            Link current = last.next;
            do {
                res += current.data + "";
                current = current.next;
            } while (current != last.next);
        }
        res += "]";
        return res;
    }

    public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList();
        c.insertLast(1);
        c.insertLast(2);
        c.insertLast(3);
        c.insertFirst(0);
        System.out.println(c);
        System.out.println("Deleteditem:" + c.removeFirst());
        System.out.println(c);
        System.out.println("Deleteditem:" + c.removeLast());
        System.out.println(c);
        System.out.println("Deleteditem:" + c.removeLast());
        System.out.println(c);
        System.out.println("Deleteditem:" + c.removeFirst());
        System.out.println(c);
    }
}
