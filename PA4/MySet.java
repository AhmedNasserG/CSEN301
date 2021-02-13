package CSEN301.PA4;

public class MySet {
    int[] arr;
    int count;

    public MySet() {
        arr = new int[100];
        count = 0;
    }

    public int cardinality() {
        return count;
    }


    public int find(int element) {
        for (int i = 0; i < count; i++) {
            if (element == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int element) {
        return find(element) != -1;
    }

    public void insert(int element) {
        if (contains(element)) {
            System.out.println("the element is already inserted");
        } else if (count == arr.length) {
            System.out.println("Sorry, the Set is full");
        } else {
            arr[count++] = element;
        }
    }

    public void remove(int element) {
        int idx = find(element);
        if (idx == -1) {
            return;
        }
        for (int i = idx; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
    }

    void replace(int x, int y) {
        int idx = find(x);
        if (idx == -1) {
            insert(y);
        } else {
            arr[idx] = y;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySet s = new MySet();
        s.insert(1);
        s.insert(1);
        s.insert(2);
        s.insert(4);
        System.out.println("Original␣State:");
        s.display();
        s.remove(2);
        System.out.println("After␣Delete:");
        s.display();
        System.out.print("Does␣Set␣contain␣4?␣");
        System.out.println(s.contains(4));
        System.out.print("Does␣Set␣contain␣2?␣");
        System.out.println(s.contains(2));
        s.replace(1, 5);
        System.out.println("After␣replace␣1␣with␣5");
        s.display();
        System.out.println(s.isEmpty());
    }
}
