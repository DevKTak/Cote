package programmers.level1;

public class 시저암호 {

  public static void main(String[] args) {
    String s = "a B z";
    int n = 4;

    StringBuilder sb = new StringBuilder();


    /** 방법 1: **/
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (Character.isLowerCase(ch)) {
        sb.append((char) ((ch - 'a' + n) % 26 + 'a'));
      } else if (Character.isUpperCase(ch)) {
        sb.append((char) ((ch - 'A' + n) % 26 + 'A'));
      } else {
        sb.append(ch);
      }
    }

    /** 방법 2: **/
 /*   for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        sb.append(" ");
      } else if (s.charAt(i) + n > 90 && s.charAt(i) < 97
         || s.charAt(i) + n > 122) {
        sb.append((char) (s.charAt(i) + n - 26));
      } else {
        sb.append((char) (s.charAt(i) + n));
      }
    }*/

    System.out.println(sb.toString());
  }
}
