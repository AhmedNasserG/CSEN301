package CSEN301.PA2;

public class ShakerSort {
    static void ShakerSort(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int j = i, k = arr.length - 1 - i;
            while (j < arr.length - 1 && k > 0){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                if (arr[k] < arr[k - 1]){
                    int temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                }
                j++;
                k--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 1, 7, 9, 4, 3, 5};
        ShakerSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
