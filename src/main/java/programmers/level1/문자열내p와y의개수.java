package programmers.level1;

public class 문자열내p와y의개수 {

  public static void main(String[] args) {
    String s = "pPoooyY";

    s = s.toLowerCase();
    int cnt = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'p') {
        cnt++;
      } else if (s.charAt(i) == 'y') {
        cnt--;
      }
    }
    System.out.println(cnt == 0);
  }
}
