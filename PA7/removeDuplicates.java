package CSEN301.PA7;

public class removeDuplicates {
    public static void removeDuplicates(LinkList l) {
        LinkList temp = new LinkList();
        while (!l.isEmpty()) {
            Object o = l.removeFirst();
            if (temp.isEmpty() || (int) temp.getFirst() != (int) o) {
                temp.insertFirst(o);
            }
        }
        while (!temp.isEmpty()) {
            l.insertFirst(temp.removeFirst());
        }
    }

    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(3);
        l.insertLast(5);
        l.insertLast(7);
        l.insertLast(7);
        l.insertLast(15);
        System.out.println(l);
        l.removeDuplicates();
        System.out.println(l);
    }
}
