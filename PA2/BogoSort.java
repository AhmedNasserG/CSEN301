package CSEN301.PA2;

public class BogoSort {
    static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    static void shuffle(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
    static void BogoSort(int[] arr){
        while (!isSorted(arr)){
            shuffle(arr);
        }
    }
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 6};
        BogoSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
