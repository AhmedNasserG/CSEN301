package CSEN301.PA4;

import CSEN301.PA5.QueueObj;

public class PalindromeUsingStacksAndQueues {
    static boolean isPalindrome(String str) {
        int size = str.length();
        StackObj s = new StackObj(size);
        QueueObj q = new QueueObj(size);
        for (int i = 0; i < size / 2; i++) {
            s.push(str.charAt(i));
        }
        for (int i = size / 2 + size % 2; i < size; i++) {
            q.enqueue(str.charAt(i));
        }
        while (!s.isEmpty()) {
            if ((char) q.dequeue() != (char) s.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("radar"));
        System.out.println(isPalindrome("mom"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("raddr"));
        System.out.println(isPalindrome("radal"));
        System.out.println(isPalindrome("Racecar"));
        System.out.println(isPalindrome("Hello"));
    }
}
