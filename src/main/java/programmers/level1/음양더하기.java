package programmers.level1;

public class 음양더하기 {
  public static void main(String[] args) {
    System.out.println(solution());
  }

  private static int solution() {
    int[] absolutes = {4, 7, 12};
    boolean[] signs = {true, false, true};

    int sum = 0;

    for (int i = 0; i < absolutes.length; i++) {
      sum += absolutes[i] * (signs[i] ? 1 : -1);
    }

    return sum;
  }
}
