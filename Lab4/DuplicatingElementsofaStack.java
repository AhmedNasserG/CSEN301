package CSEN301.Lab4;

import CSEN301.PA3.ArrayStack;
import CSEN301.PA4.StackObj;

import java.util.Stack;


public class DuplicatingElementsofaStack {
    static StackObj duplicate(StackObj names, StackObj nums) {
        int newSize = 0;
        StackObj temp = new StackObj(nums.size());
        while (!nums.isEmpty()) {
            newSize += (int) nums.top();
            temp.push(nums.pop());
        }
        while (!temp.isEmpty()) {
            nums.push(temp.pop());
        }
        StackObj res = new StackObj(newSize);
        while (!names.isEmpty()) {
            int i = (int) nums.pop();
            String currentName = (String) names.pop();
            for (int j = 0; j < i; j++) {
                res.push(currentName);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StackObj s = new StackObj(3);
        s.push(2);
        s.push(3);
        s.push(1);
        StackObj a = new StackObj(3);
        a.push("Slim");
        a.push("Abdellatif");
        a.push("Hend");
        StackObj r = duplicate(a, s);
        r.printStack();
    }
}
