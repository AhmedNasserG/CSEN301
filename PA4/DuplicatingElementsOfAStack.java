package CSEN301.PA4;


public class DuplicatingElementsOfAStack {
    static StackObj createDuplicates(StackObj names, StackObj freq) {
        StackObj temp = new StackObj(freq.size());
        int newSize = 0;
        while (!freq.isEmpty()) {
            newSize += (int) freq.top();
            temp.push(freq.pop());
        }
        while (!temp.isEmpty()) {
            freq.push(temp.pop());
        }
        temp = new StackObj(newSize);
        while (!names.isEmpty() && !freq.isEmpty()) {
            String str = (String) names.pop();
            int i = (int) freq.pop();
            for (int j = 0; j < i; j++) {
                temp.push(str);
            }
        }
        return temp;
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
        StackObj r = createDuplicates(a, s);
        r.printStack();
    }
}
