package CSEN301.PA5;

public class PrefixEvaluation {
    static int evaluate(String exp) {
        String[] arr = exp.split(" ");
        QueueObj q = new QueueObj(arr.length);
        QueueObj temp = new QueueObj(3);
        for (String item : arr) {
            q.enqueue(item);
        }
        while (q.size() > 1) {
            if (((String) q.peek()).charAt(0) >= '0' && ((String) q.peek()).charAt(0) <= '9') {
                q.enqueue(q.dequeue());
            } else {
                temp.enqueue(q.dequeue());
                int count = 0;
                while (count < 2) {

                    if (((String) q.peek()).charAt(0) >= '0' && ((String) q.peek()).charAt(0) <= '9') {
                        temp.enqueue(q.dequeue());
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == 2) {
                    calculate(q,temp);
                } else {
                    while (!temp.isEmpty()) {
                        q.enqueue(temp.dequeue());
                    }
                }
            }

        }
        return Integer.parseInt(((String) q.dequeue()));
    }

    static void calculate(QueueObj q, QueueObj temp) {
        switch ((String) temp.dequeue()) {
            case "+":
                q.enqueue((Integer.parseInt(((String) temp.dequeue())) + Integer.parseInt(((String) temp.dequeue()))) + "");
                break;
            case "-":
                q.enqueue((Integer.parseInt(((String) temp.dequeue())) - Integer.parseInt(((String) temp.dequeue()))) + "");
                break;
            case "*":
                q.enqueue((Integer.parseInt(((String) temp.dequeue())) * Integer.parseInt(((String) temp.dequeue()))) + "");
                break;
            case "/":
                q.enqueue((Integer.parseInt(((String) temp.dequeue())) / Integer.parseInt(((String) temp.dequeue()))) + "");
                break;
        }

    }

    public static void main(String[] args) {
        String input = "+ 1 * 2 3"; //7
        System.out.println(input + "=" + evaluate(input));
        input = "- + * 9 + 2 8 * + 4 8 6 3";//159
        System.out.println(input + "=" + evaluate(input));
         input = "+ 10 * 2 3";//16
        System.out.println(input + "=" + evaluate(input));
        input = "* 5 + 20 / 24 6";//120
        System.out.println(input + "=" + evaluate(input));
        input = "/ * 4 + 3 4 2";//14
        System.out.println(input + "=" + evaluate(input));
        input = "+ * 10 2" +
                "" +
                "5 / 25 5";//255
        System.out.println(input + "=" + evaluate(input));
    }
}
