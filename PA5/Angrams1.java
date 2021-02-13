package CSEN301.PA5;

public class Angrams1 {
    public static boolean isAng(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int size = a.length();
        QueueObj qA = new QueueObj(size);
        QueueObj qB = new QueueObj(size);
        for (int i = 0; i < size; i++) {
            qA.enqueue(a.charAt(i));
            qB.enqueue(b.charAt(i));
        }
        while (!qA.isEmpty()) {
            int sizeQ = qA.size();
            boolean flag = false;
            for (int i = 0; i < sizeQ; i++) {
                if ((char) qA.peek() == (char) qB.peek()) {
                    qA.dequeue();
                    qB.dequeue();
                    flag = true;
                    break;
                }
                qB.enqueue(qB.dequeue());
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAng("stop", "post"));
        System.out.println(isAng("stop", "spot"));
        System.out.println(isAng("orchestra", "carthorse"));
        System.out.println(isAng("stop", "posst"));
        System.out.println(isAng("abb", "bba"));
    }
}
