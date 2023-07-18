package programmers.level1;

public class _2016년 {

  public static void main(String[] args) {
    int a = 5;
    int b = 24;

    System.out.println(solution(a, b));
  }

  private static String solution(int a, int b) {
    int sum = 0;

    for (int i = 1; i < a; i++) {
      if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
        sum += 31;
      } else if (i == 2) {
        sum += 29;
      } else {
        sum += 30;
      }
    }
    sum += b;

    switch (sum % 7) {
      case 0:
        return "THU";
      case 1:
        return "FRI";
      case 2:
        return "SAT";
      case 3:
        return "SUN";
      case 4:
        return "MON";
      case 5:
        return "TUE";
      default:
        return "WED";
    }
  }
}
