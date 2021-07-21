package programmers.level1;

public class 약수의개수와덧셈 {

  public static void main(String[] args) {
    int left = 13, right = 17;
    System.out.println(solution(left, right));
  }

  private static int solution(int left, int right) {
    int sum = 0;

    for (int i = left; i <= right; i++) {
      sum += getSign(i) * i;
      System.out.println("sum = " + sum);
    }

    return sum;
  }

  private static int getSign(int num) {
    int cnt = 0;

    for (int i = 1; i <= num; i++) {
      if (num % i == 0) {
        cnt++;
      }
    }

    return cnt % 2 == 0 ? 1 : -1;
  }
}
