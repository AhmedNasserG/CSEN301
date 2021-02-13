package CSEN301.PA5;

public class Anagrams {
    static boolean anagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int size = a.length();
        QueueObj q1 = new QueueObj(size);
        QueueObj q2 = new QueueObj(size);
        for (int i = 0; i < size; i++) {
            q1.enqueue(a.charAt(i));
            q2.enqueue(b.charAt(i));
        }
        while (!q1.isEmpty()) {
            Character currentA = (Character) q1.dequeue();
            Character currentB = (Character) q2.dequeue();
            Character headB = currentB;
            while (currentA.charValue() != currentB.charValue()) {
                q2.enqueue(currentB);
                currentB = (Character) q2.dequeue();
                if (headB == currentB) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(anagrams("stop", "post"));
        System.out.println(anagrams("stop", "spot"));
        System.out.println(anagrams("orchestra", "carthorse"));
        System.out.println(anagrams("stop", "posst"));
        System.out.println(anagrams("abb", "bba"));
    }
}
