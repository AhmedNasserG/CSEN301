package CSEN301.PA11;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
    static int[] removeDuplicate(int[] a) {
        int n = a.length;
        int index = 0;
        HashSet<Integer> hs = new HashSet<>();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            if (!hs.contains(a[i])) {
                b[index++] = a[i];
                hs.add(a[i]);
            }
        }
        int[] res = new int[index];
        for (int i = 0; i < index; i++) {
            res[i] = b[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int test[] ={
            10, 1, 2, 6, 5, 1, 10, 19, -3, -3, 1, 0, 20, 2
        };
        System.out.println(Arrays.toString(removeDuplicate(test)));
    }
}
