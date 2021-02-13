package CSEN301.PA1;

public class LinearArray {
    int[] arr;
    int numOfElements;

    public LinearArray(int maxSize) {
        arr = new int[maxSize];
        numOfElements = 0;
    }

    public void insertLast(int x) {
        if (numOfElements == arr.length) {
            System.out.println("Array is full");
        } else {
            arr[numOfElements++] = x;
        }

    }

    public void insertFirst(int x) {
        if (numOfElements == arr.length) {
            System.out.println("Array is full");
        } else {
            for (int i = numOfElements - 1; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = x;
            numOfElements++;
        }
    }

    public int linearSearch(int x) {
        for (int i = 0; i < numOfElements; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int x) {
        int idx = linearSearch(x);
        if (idx == -1) {
            System.out.println("item is not the array");
        } else {
            for (int i = idx; i < numOfElements - 1; i++) {
                arr[i] = arr[i + 1];
            }
            numOfElements--;

        }
    }
    public void display(){
        for (int i = 0; i < numOfElements; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        LinearArray a = new LinearArray(10);
        a.insertLast(3);
        a.insertLast(7);
        a.insertFirst(8);
        a.display();
        System.out.println("Count: " + a.numOfElements);
        System.out.println("Position of 8: " + a.linearSearch(8));
        System.out.println("Position of 5: " + a.linearSearch(5));
        a.delete(33);
        a.delete(3);
        System.out.println("Count: " + a.numOfElements);
    }

}
