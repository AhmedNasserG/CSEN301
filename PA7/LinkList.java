package CSEN301.PA7;

import java.util.List;

class Link {
    public Object data;
    public Link next;

    public Link(Object o) {
        this.data = o;
        this.next = null;
    }

    public String toString() {
        return data.toString();
    }
}

public class LinkList {
    private Link head;

    public LinkList() {
        head = null;
    }

    public void insertFirst(Object o) {
        Link newLink = new Link(o);
        newLink.next = head;
        head = newLink;
    }

    public Object removeFirst() {
        Object res = head.data;
        head = head.next;
        return res;
    }

    public Object getFirst() {
        return head.data;
    }

    public void insertLast(Object o) {
        Link newLink = new Link(o);
        if (head == null) {
            head = newLink;
            return;
        }
        Link current = head;
        while (current.next != null)
            current = current.next;
        current.next = newLink;
    }

    public void insertLastRec(Object o) {
        helper(head, o);
    }

    public void helper(Link current, Object o) {
        if (current == null) {
            head = new Link(o);
            return;
        }
        if (current.next == null) {
            current.next = new Link(o);
            return;
        }
        helper(current.next, o);
    }

    public Object removeLast() {
        if (head.next == null) {
            Object res = head.data;
            head = null;
            return res;
        }
        Link current = head;
        while (current.next.next != null)
            current = current.next;
        Object res = current.next.data;
        current.next = null;
        return res;
    }

    public Object getLast() {
        Link current = head;
        while (current.next != null)
            current = current.next;
        return current.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        if (head == null)
            return "[ ]";
        String res = "[ " + head.data;
        Link current = head.next;
        while (current != null) {
            res += ", " + current.data;
            current = current.next;
        }
        res += " ]";
        return res;
    }

    public void reverse() {
        Link previous = null;
        Link current = null;
        Link following = head;
        while (following != null) {
            current = following;
            following = current.next;
            current.next = previous;
            previous = current;
        }
        head = current;
    }

    //	void cutList() {
//		int count = 0;
//		Link current = head;
//		while (current != null) {
//			current = current.next;
//			count++;
//		}
//		for (int i = 0; i < count / 2; i++) {
//			Link preLast = head;
//			while (preLast.next.next != null){
//				preLast = preLast.next;
//			}
//			preLast.next.next = head;
//			head = preLast.next;
//			preLast.next = null;
//		}
//
//	}
    void cutList() {
        if (head == null) {
            return;
        }
        int count = 1;
        Link current = head;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        current.next = head;
        current = head;
        for (int i = 0; i < count / 2; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
    }

    void merge(LinkList l) {
        Link current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = l.head;
    }

    boolean equals(LinkList l){
        Link current1 = head;
        Link current2 = l.head;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data){
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        if (current1 != null || current2 != null){
            return false;
        }
        return true;
    }

    void removeDuplicates(){
        if (head == null || head.next == null){
            return;
        }
        Link current = head.next;
        Link prev = head;
        while (prev.next != null) {
            if (!current.data.equals(prev.data)) {
                prev.next = current;
                prev = current;
            }
            current = current.next;
        }
    }

}
