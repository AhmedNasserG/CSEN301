package CSEN301.PA6;

public class Customer implements Comparable {
    int ResNum;
    boolean PriorRes;

    public Customer(int ResNum, boolean PriorRes){
        this.ResNum = ResNum;
        this.PriorRes = PriorRes;
    }
    @Override
    public int compareTo(Object o) {
        Customer c = (Customer) o;
        if (ResNum == c.ResNum){
            if (PriorRes){
                return -1;
            }
            if (c.PriorRes){
                return 1;
            }
        }
        if (ResNum > c.ResNum){
            return 1;
        }else {
            return -1;
        }


    }

    @Override
    public String toString() {
        return "Customer{" +
                "ResNum=" + ResNum +
                ", PriorRes=" + PriorRes +
                '}';
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(100);
        pq.insert(new Customer(3,false));
        pq.insert(new Customer(1,false));
        pq.insert(new Customer(4,false));
        pq.insert(new Customer(4,true));
        pq.insert(new Customer(2,false));

        while (!pq.isEmpty()){
            System.out.println((Customer) pq.remove());
        }
    }
}
