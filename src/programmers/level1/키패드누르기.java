package programmers.level1;

public class 키패드누르기 {

  public static void main(String[] args) {
    int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    String hand = "right";
    System.out.println(solution(numbers, hand));
  }

  private static String solution(int[] numbers, String hand) {
    StringBuilder sb = new StringBuilder();
    Coordinates leftFinger;
    Coordinates rightFinger;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        sb.append("L");
      } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        sb.append("R");
      } else {

      }
    }

    return "";
  }

  private static class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public void setX(int x) {
      this.x = x;
    }

    public void setY(int y) {
      this.y = y;
    }
  }
}
