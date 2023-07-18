package programmers.level1;

public class 하샤드수 {

  public static void main(String[] args) {
    int x = 10;

    int xCopy = x;
    int sum = 0;

    while (xCopy > 0) {
      sum += xCopy % 10;
      xCopy /= 10;
    }

    System.out.println(x % sum == 0);
  }
}
