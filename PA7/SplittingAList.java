package CSEN301.PA7;

public class SplittingAList {
    static void frontBackSplit(LinkList l){
        LinkList front = new LinkList();
        LinkList back = new LinkList();
        LinkList temp = new LinkList();
        int count = 0;
        while (!l.isEmpty()){
            temp.insertFirst(l.removeFirst());
            count++;
        }
        int i;
        for (i = 0; i < count / 2; i++) {
            back.insertFirst(temp.getFirst());
            l.insertFirst(temp.removeFirst());
        }
        for (i = i; i < count; i++) {
            front.insertFirst(temp.getFirst());
            l.insertFirst(temp.removeFirst());
        }
        System.out.println(l);
        System.out.println(front);
        System.out.println(back);
    }

    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertLast(2);
        l.insertLast(3);
//        l.insertLast(5);
//        l.insertLast(7);
//        l.insertLast(11);
        frontBackSplit(l);
    }
}
