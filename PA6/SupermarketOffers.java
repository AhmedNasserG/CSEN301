package CSEN301.PA6;

import CSEN301.PA4.StackObj;

import java.util.Date;

public class SupermarketOffers {
    static class YoghurtProduct implements Comparable {
        int id;
        double originalPrice;
        Date expiryDate;

        public YoghurtProduct(int id, double originalPrice, Date expiryDate) {
            this.id = id;
            this.expiryDate = expiryDate;
            this.originalPrice = originalPrice;
        }

        public int compareTo(Object o) {
            YoghurtProduct Y = (YoghurtProduct) o;
            return expiryDate.compareTo(Y.expiryDate);
        }
    }

    PriorityQueue pq;

    public SupermarketOffers(int maxSize) {
        pq = new PriorityQueue(maxSize);
    }

    public void addProd(YoghurtProduct p) {
        if (!pq.isFull()) {
            pq.insert(p);
        } else {
            System.out.println("Sorry Supermarket is full");
        }
    }

    public double newPrice(int productID) {
        StackObj stack = new StackObj(pq.size());
        int count = 0;
        YoghurtProduct current = null;
        boolean found = false;
        while (!pq.isEmpty()) {
            current = (YoghurtProduct) pq.remove();
            if (stack.isEmpty() || !((YoghurtProduct) stack.top()).expiryDate.equals(current.expiryDate)) {
                count++;
            }
            if (current.id == productID) {
                found = true;
                break;
            }
            stack.push(current);
        }
        while (!stack.isEmpty()) {
            pq.insert((Comparable) stack.pop());
        }
        if (!found) {
            return -1;
        }
        return current.originalPrice * (0.45 + 0.05 * count);
    }


    public static void main(String[] args) {
        YoghurtProduct p1 = new YoghurtProduct(1, 2.0, new Date(2014, 10, 30));
        YoghurtProduct p2 = new YoghurtProduct(2, 3.0, new Date(2014, 10, 27));
        YoghurtProduct p3 = new YoghurtProduct(3, 8.0, new Date(2014, 10, 26));
        YoghurtProduct p4 = new YoghurtProduct(4, 4.0, new Date(2014, 10, 27));
        YoghurtProduct p5 = new YoghurtProduct(5, 5.0, new Date(2014, 10, 27));
        YoghurtProduct p6 = new YoghurtProduct(6, 6.0, new Date(2014, 10, 26));
        SupermarketOffers s = new SupermarketOffers(6);
        s.addProd(p1);
        s.addProd(p2);
        s.addProd(p3);
        s.addProd(p4);
        s.addProd(p5);
        s.addProd(p6);
        System.out.println(s.newPrice(4)); //45% 2.2
    }
}
