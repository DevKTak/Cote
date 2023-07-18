package programmers.level1;

public class _1주차 {

  public static void main(String[] args) {
    int price = 1, money = 1, count = 1;
    System.out.println(solution(price, money, count));
  }

  private static long solution(int price, int money, int count) {
    long sum = price;

    for (int i = 2; i <= count; i++) {
      sum += price * i;
    }

    return sum > money ? sum - money : 0;
  }
}
