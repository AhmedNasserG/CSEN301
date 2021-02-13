package CSEN301.PA8;

import LeetCode.TopInterviewQuestions.LinkedList.LinkedListCycle;

import java.util.LinkedList;

class Link {
    public Object data;
    public Link next;
    public Link previous;

    public Link(Object o) {
        data = o;
    }

    public String toString() {
        return data.toString();
    }
}

class DoublyLinkedList {
    private Link first; // reference to first link on list
    private Link last; // reference to first link on list

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(Object d) {
        Link newLink = new Link(d);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(Object d) {
        Link newLink = new Link(d);
        if (isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Object removeFirst() {
        Object temp = first.data;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public Object removeLast() {
        Object temp = last.data;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public Object getFirst() {
        return first.data;
    }

    public Object getLast() {
        return last.data;
    }

    public void displayForward() {
        System.out.print("[ ");
        Link current = first;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    public void displayBackward() {
        System.out.print("[ ");
        Link current = last;
        while (current != null) {
            System.out.print(current + " ");
            current = current.previous;
        }
        System.out.println("]");
    }

    int countIter() {
        int count = 0;
        Link current = first;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

//    int countRec() {
//        return helper(first);
//    }
//
//    int helper(Link current) {
//        if (current == null) {
//            return 0;
//        }
//        return 1 + helper(current.next);
//    }

    Comparable max() {
        if (first == null) {
            return null;
        }
        Link current = first.next;
        Comparable max = (Comparable) first.data;
        while (current != null) {
            if (max.compareTo((Comparable) current.data) < 0) {
                max = (Comparable) current.data;
            }
            current = current.next;
        }
        return max;
    }

    Object maxRec(Link l) {
        if (l.next == null) {
            return l.data;
        }
        Comparable m = (Comparable) maxRec(l.next);
        if (m.compareTo(l.data) < 0) {
            return l.data;
        }
        return m;
    }

    boolean contains(Object o) {
        Link Current = first;
        while (Current != null) {
            if (Current.equals(o)) {
                return true;
            }
            Current = Current.next;
        }

        return false;
    }

    boolean containsRec(Object o) {
        return helper(o, first);
    }

    boolean helper(Object o, Link l) {
        if (l == null) {
            return false;
        }
        if (o.equals(l.data)) {
            return true;
        }
        return helper(o, l.next);
    }

    boolean insertAfter(Object key, Object dd) {
        Link current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        Link l = new Link(dd);
        if (current.next == null) {
            l.next = null;
            current.next = l;
            l.previous = current;
            last = l;
            return true;
        }
        l.next = current.next;
        current.next = l;
        l.next.previous = l;
        l.previous = current;
        return true;
    }

    boolean insertBefore(Object key, Object dd) {
        Link current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        Link l = new Link(dd);
        if (current.previous == null) {
            l.previous = null;
            current.previous = l;
            l.next = current;
            first = l;
            return true;
        }
        l.previous = current.previous;
        current.previous = l;
        l.previous.next = l;
        l.next = current;
        return true;
    }

    Object deleteKey(Object key) {
        Link current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (first.next == null) {
            first = null;
            last = null;
            return current.data;
        }
        if (current.next == null) {
            current.previous.next = null;
            last = last.previous;
            return current;
        }
        if (current.previous == null) {
            current.next.previous = null;
            first = first.next;
            return current;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        return current.data;
    }

    void insertToSorted(Comparable x) {
        Link current = first;
        Link l = new Link(x);
        if (first == null) {
            first = l;
            last = l;
            return;
        }
        while (current != null && x.compareTo((Comparable) current.data) > 0) {
            current = current.next;
        }
        if (current == null) {
            l.next = null;
            last.next = l;
            l.previous = last;
            last = l;
            return;
        }
        if (current.previous == null) {
            l.previous = null;
            current.previous = l;
            l.next = current;
            first = l;
            return;
        }
        l.previous = current.previous;
        current.previous = l;
        l.previous.next = l;
        l.next = current;

    }

    void insertionSort() {
        Link current = first;
        DoublyLinkedList temp = new DoublyLinkedList();
        while (current != null) {
            temp.insertToSorted((Comparable) current.data);
            current = current.next;
        }
        first = temp.first;
        last = temp.last;
    }

    void reverse() {
        Link current = first;
        while (current != null) {
            Link temp = current.next;
            current.next = current.previous;
            current.previous = temp;
            current = current.previous;
        }
        current = last;
        last = first;
        first = current;
    }

    void reverse2() {
        helper(first);
        Link current = last;
        last = first;
        first = current;
    }

    void helper(Link current) {
        if (current == null) {
            return;
        }
        Link temp = current.next;
        current.next = current.previous;
        current.previous = temp;
        helper(current.previous);
    }



    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();
        l.insertLast(0);
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(5);
        l.reverse2();
        l.displayForward();
        l.displayBackward();
    }
}