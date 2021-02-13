package CSEN301.PA7;

public class insertion {
    public static void insertLast(LinkList l, Object o) {
        LinkList temp = new LinkList();
        while (!l.isEmpty()) {
            temp.insertFirst(l.removeFirst());
        }
        temp.insertFirst(new Link(o));
        while (!temp.isEmpty()) {
            l.insertFirst(temp.removeFirst());
        }
    }

    public static Object removeLast(LinkList l, Object o) {
        LinkList temp = new LinkList();
        while (!l.isEmpty()) {
            temp.insertFirst(l.removeFirst());
        }
        Object res = temp.removeFirst();
        while (!temp.isEmpty()) {
            l.insertFirst(temp.removeFirst());
        }
        return res;
    }


        public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLastRec(5);
        l.insertLastRec(4);
        l.insertLastRec(3);
        l.insertLastRec(2);
        l.insertLastRec(1);
        System.out.println(l);
    }
}
