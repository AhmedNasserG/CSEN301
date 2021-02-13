package CSEN301.PA7;

public class reversation {
    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLastRec(5);
        l.insertLastRec(4);
        l.insertLastRec(3);
        l.insertLastRec(2);
        l.insertLastRec(1);
        System.out.println(l);
        l.reverse();
        System.out.println(l);
    }
}
