package CSEN301.PA7;

public class AlternatingSplit {
    static void alternatingSplit(LinkList l){
        LinkList first = new LinkList();
        LinkList second = new LinkList();
        LinkList temp = new LinkList();
        while (!l.isEmpty()) {
            first.insertLast(l.getFirst());
            temp.insertFirst(l.removeFirst());
            if (!l.isEmpty()){
                second.insertLast(l.getFirst());
                temp.insertFirst(l.removeFirst());
            }
        }
        while (!temp.isEmpty()){
            l.insertFirst(temp.removeFirst());
        }
        System.out.println(l);
        System.out.println(first);
        System.out.println(second);
    }

    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLast('a');
        l.insertLast('b');
        l.insertLast('c');
        l.insertLast('d');
        l.insertLast('e');
        alternatingSplit(l);
    }
}
