package CSEN301.Other;

import CSEN301.PA4.StackObj;

import java.util.Arrays;

public class nextSmaller {
    public static void nextSmaller(int[] arr) {
        StackObj s = new StackObj(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                s.push(arr[i]);
            } else {
                if (arr[i] < arr[i + 1]){
                    if (arr[i] < (int)s.top()){
                        s.push(arr[i]);
                    } else {
                        s.push(s.top());
                    }
                }else {
                    s.push(arr[i + 1]);
                }
            }
        }
        for (int i = 0; i < arr.length;i++){
            arr[i] = (int) s.pop();
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5};
        nextSmaller(a);
        System.out.println(Arrays.toString(a));
    }
}
