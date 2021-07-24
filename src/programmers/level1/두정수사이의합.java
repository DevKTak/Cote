package programmers.level1;

public class 두정수사이의합 {

  public static void main(String[] args) {
    int a = 0, b = -3;

    int min = Math.min(a, b);
    int max = Math.max(a, b);
    int n = max - min + 1;

    System.out.println(((long)n * ((2 * min) + (n - 1))) / 2);
  }
}
