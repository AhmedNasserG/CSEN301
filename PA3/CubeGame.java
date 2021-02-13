package CSEN301.PA3;

import java.util.Random;

public class CubeGame {
    static boolean check(ArrayStack x) {
        int firstSum = 0, secondSum = 0, size = x.size();
        ArrayStack temp = new ArrayStack(size);
        for (int i = 0; i < size / 2; i++) {
            int current = x.pop();
            firstSum += current;
            temp.push(current);
        }
        if (size % 2 == 1) {
            temp.push(x.pop());
        }
        for (int i = 0; i < size / 2; i++) {
            int current = x.pop();
            secondSum += current;
            temp.push(current);
        }
        while (!temp.isEmpty()){
            x.push(temp.pop());
        }
        return firstSum == secondSum;
    }

    public static void main(String args[]) {
        ArrayStack s = new ArrayStack(5);
        s.push(9);
        s.push(3);
        s.push(8);
        s.push(8);
        s.push(4);
        System.out.println(check(s));

    }
}
