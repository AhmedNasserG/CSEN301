package CSEN301.PA3;

public class SearchInAStack {
    static int search(int x, ArrayStack stack){
        ArrayStack temp = new ArrayStack(stack.size());
        int res = 0;
        while (!stack.isEmpty()){
            if (stack.top() == x){
                return res;
            }
            temp.push(stack.pop());
            res++;
        }
        return -1;
    }
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        stack.push(5);
        stack.push(7);
        stack.push(1);
        stack.push(-5);
        System.out.println(search(1,stack));
    }
}
