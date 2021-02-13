package CSEN301.PA2;

public class IndexSort {
    static int[] IndexSort(int[] arr){
        int length = arr.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int current = arr[i];
            int count = 0;
            for (int j = 0; j < length; j++) {
                if(current > arr[j] || (current == arr[j] && i < j)){
                    count++;
                }
            }
            res[count] = current;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 8, 1, 7, 9, 4, 3, 5};
        arr = IndexSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
