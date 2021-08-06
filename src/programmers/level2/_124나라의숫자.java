package programmers.level2;

public class _124나라의숫자 {

  public static void main(String[] args) {
    int n = 102930;

    String[] number = {"4", "1", "2"}; // String 배열이 아닌 int 배열로 선언하면 시간효율 탈락!
    String answer = "";

    while (n > 0) {
      answer = number[n % 3] + answer;
      n = (n - 1) / 3;
    }
    System.out.println(answer);
  }
}
