package CSEN301.PA2;

public class RecursiveBubbleSort {
    static void BubbleSortRec(int[] arr, int i) {
        if (i == arr.length - 1) {
            return;
        }
        boolean isSorted = true;
        for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                isSorted = false;
            }
        }
        if (isSorted) {
            return;
        }
        BubbleSortRec(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 6};
        BubbleSortRec(arr, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
