package CSEN301.PA4;

public class ValidPrefixExpression {
  public static boolean isValid(String str) {
    String[] arr = str.split(" ");
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/")) {
        if (count == 0) {
          count += 2;
        } else {
          count++;
        }
      } else {
        count--;
        if (count < 0) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isValid("+ 3 4 - 8 8 + * 1 2 4"));
  }
}
