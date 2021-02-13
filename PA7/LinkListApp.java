package CSEN301.PA7;

public class LinkListApp {
    static void merge(LinkList l, LinkList m){
        while (!m.isEmpty()){
            l.insertLast(m.removeFirst());
        }
    }
    static boolean equals(LinkList l, LinkList m){
        return false;
    }
    public static void main(String[] args) {
        LinkList l = new LinkList();
        LinkList m = new LinkList();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        m.insertLast(1);
        m.insertLast(2);
        m.insertLast(3);
//        m.insertLast(7);
//        l.merge(m);
//        merge(l,m);
        System.out.println(l.equals(m));
    }
}
