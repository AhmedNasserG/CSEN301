package CSEN301.PA2;

public class ModifiedSelectionSort {
    static void MSelectionSort(int[] arr){
        int i = 0, k = arr.length - 1;
        while (i < k){
            int minValue = arr[i];
            int minIndex = i;
            int maxValue = arr[i];
            int maxIndex = i;
            for (int j = i + 1; j <= k; j++) {
                if (minValue > arr[j]){
                    minValue = arr[j];
                    minIndex = j;
                }
                if (maxValue < arr[j]){
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            if (i == maxIndex){
                maxIndex = minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            temp = arr[k];
            arr[k] = arr[maxIndex];
            arr[maxIndex] = temp;
            i++;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 1, 7, 9, 4, 3, 5};
        MSelectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
