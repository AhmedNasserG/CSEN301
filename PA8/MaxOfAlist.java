package CSEN301.PA8;

public class MaxOfAlist {
    static Object max(DoublyLinkedList l) {
        if (l.isEmpty()) {
            return null;
        }
        Comparable max = (Comparable) l.removeFirst();
        while (!l.isEmpty()) {
            if (max.compareTo((Comparable) l.getFirst()) < 0) {
                max = (Comparable) l.removeFirst();
            } else {
                l.removeFirst();
            }
        }
        return max;
    }
}
