package CSEN301.PA2;

public class CountingSort {
    static void booleanSort(int[] arr){
        int max = 0;
        for (int i : arr) {
            if(max < i){
                max = i;
            }
        }
        boolean[] boolArray = new boolean[max + 1];
        for (int i : arr) {
            boolArray[i] = true;
        }
        int index = 0;
        for (int i = 0; i < max + 1; i++) {
            if(boolArray[i]){
                arr[index++] = i;
            }
        }
    }

    static void countSort(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if(max < i){
                max = i;
            }
        }
        int[] memo = new int[max + 1];
        for (int i : arr) {
            memo[i]++;
        }
        int index = 0;
        for (int i = 0; i < max + 1; i++) {
            for (int j = 0; j < memo[i]; j++) {
                arr[index++] = i;
            }
        }

    }
        public static void main(String[] args) {
        int[] arr = {2, 2, 8, 1, 7, 9, 4, 3, 5};
        countSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
