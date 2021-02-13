package CSEN301.PA1;


public class LinearSortedArray {

    int[] arr;
    int count;

    LinearSortedArray(int maxSize) {
        arr = new int[maxSize];
    }

    void orderedInsert1(int x) {
        if (count == arr.length) {
            System.out.println("Array is full");
        } else {
            int i;
            for (i = 0; i < count; i++) {
                if (x < arr[i]) {
                    break;
                }
            }
            for (int j = count; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[i] = x;
            count++;
        }
    }

    void orderedInsert(int x) {
        if (count == arr.length) {
            System.out.println("Array is full");
        } else {
            int i;
            for (i = count - 1; i >= 0 && arr[i] > x; i--) {
                arr[i + 1] = arr[i];
            }
            arr[i + 1] = x;
            count++;
        }
    }

    int binarySearchIter(int x) {
        int start = 0, end = count - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int binarySearchRec(int x, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] > x) {
            return binarySearchRec(x, start, mid - 1);
        } else {
            return binarySearchRec(x, mid + 1, end);
        }
    }

    void delete(int x) {
        int idx = binarySearchIter(x);
        if (idx == -1) {
            System.out.println("item is not the array");
        } else {
            for (int i = idx; i < count - 1; i++) {
                arr[i] = arr[i + 1];
            }
            count--;
            
            
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < count; i++) {
            res += arr[i] + " ";
        }
        return res;
    }

    public static void main(String[] args) {
        LinearSortedArray arr = new LinearSortedArray(4);
        arr.orderedInsert(5);
        arr.orderedInsert(4);
        arr.orderedInsert(6);
        arr.orderedInsert(8);
        arr.orderedInsert(0);
        System.out.println(arr);
//        System.out.println(arr.binarySearchIter(8));
//        System.out.println(arr.binarySearchRec(8, 0, arr.count - 1));
//        arr.delete(15);
//        System.out.println(arr);
    }
}
