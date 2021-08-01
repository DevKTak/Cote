package programmers.level1;

public class 자릿수더하기 {

  public static void main(String[] args) {
    int n = 123;

    String nStr = String.valueOf(n);
    int answer = 0;

    for (int i = 0; i < nStr.length(); i++) {
      answer += nStr.charAt(i) - 48;
    }
    System.out.println(answer);
  }
}
