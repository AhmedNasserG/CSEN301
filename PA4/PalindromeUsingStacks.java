package CSEN301.PA4;

import java.util.*;

class PalindromeUsingStacks {
    static boolean isPalindrome(String str) {
        // handle input Case and Spaces
        str = str.toLowerCase();
        String[] temp = str.split(" ");
        str = "";
        for (int i = 0; i < temp.length; i++) {
            str += temp[i];
        }
        StackObj stack = new StackObj(str.length() / 2);

        for (int i = 0; i < str.length() / 2; i++) {
            stack.push(str.charAt(i));
        }

        for (int i = (str.length() / 2) + str.length() % 2; i < str.length(); i++) {
            if (str.charAt(i) != (char) stack.top()) {
                return false;
            }
            stack.pop();
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
