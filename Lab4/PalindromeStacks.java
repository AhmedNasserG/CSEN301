package CSEN301.Lab4;

import CSEN301.PA4.StackObj;

public class PalindromeStacks {
    static boolean isPalindrome(String str) {
        String[] arr = str.toLowerCase().split(" ");
        str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        StackObj stack = new StackObj(str.length());
        for (int i = 0; i < str.length() / 2; i++) {
            stack.push(str.charAt(i));
        }
        for (int i = str.length() / 2 + str.length() % 2; i < str.length(); i++) {
            if (str.charAt(i) != (char) stack.pop()){
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
        System.out.println(isPalindrome("Race car"));
        System.out.println(isPalindrome("Hello"));
    }
}
