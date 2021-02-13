package CSEN301.PA7;

public class MixElementsOfAList {
    static LinkList mix(LinkList x) {
        LinkList res = new LinkList();
        while (!x.isEmpty()) {
            res.insertLast(x.removeFirst());
            if (!x.isEmpty()) {
                res.insertLast(x.removeLast());
            }
        }
        return res;
    }
}
