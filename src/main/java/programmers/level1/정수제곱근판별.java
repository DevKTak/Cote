package programmers.level1;

public class 정수제곱근판별 {

  public static void main(String[] args) {
    long n = 121;
    System.out.println(solution(n));
  }
  
  private static long solution(long n) {
    int x = (int) Math.sqrt(n); // 강제 다운캐스팅
    System.out.println("x = " + x);

    return Math.pow(x, 2) == n ? (long) Math.pow(x + 1, 2) : -1;
  }
}
