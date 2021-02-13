package CSEN301.PA7;

import java.util.List;

public class CutAList {
    static LinkList cut(LinkList x){
        LinkList l = new LinkList();
        int count = 0;
        while (!x.isEmpty()) {
            l.insertFirst(x.removeFirst());
            count++;
        }
        while (!l.isEmpty()) {
            x.insertFirst(l.removeFirst());
        }
        for (int i = 0; i < count / 2; i++) {
            x.insertFirst(x.removeLast());
        }
        return x;
    }



    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(5);
        l.insertLast(6);
        l.insertLast(7);
        l.cutList();
        System.out.println(l);
    }
}
