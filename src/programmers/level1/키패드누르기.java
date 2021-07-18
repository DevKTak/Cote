package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 키패드누르기 {

  public static void main(String[] args) {
    int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    String hand = "right";
    System.out.println(solution(numbers, hand)); // LRLLLRLLRRL
  }

  private static String solution(int[] numbers, String hand) {
    StringBuilder sb = new StringBuilder();

    Map<Integer, Object> numberMap = new HashMap<>();
    numberMap.put(1, new Coordinates(0, 3));
    numberMap.put(2, new Coordinates(1, 3));
    numberMap.put(3, new Coordinates(2, 3));
    numberMap.put(4, new Coordinates(0, 2));
    numberMap.put(5, new Coordinates(1, 2));
    numberMap.put(6, new Coordinates(2, 2));
    numberMap.put(7, new Coordinates(0, 1));
    numberMap.put(8, new Coordinates(1, 1));
    numberMap.put(9, new Coordinates(2, 1));
    numberMap.put(0, new Coordinates(1, 0));

    Coordinates curLeftFinger = new Coordinates(0, 0); // 현재 왼손 엄지손가락 위치
    Coordinates curRightFinger = new Coordinates(2, 0); // 현재 오른손 엄지손가락 위치


    for (int i = 0; i < numbers.length; i++) {
      Coordinates targetCoordinates = (Coordinates) numberMap.get(numbers[i]);

      if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        sb.append("L");
        curLeftFinger.setX(targetCoordinates.getX());
        curLeftFinger.setY(targetCoordinates.getY());
      } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        sb.append("R");
        curRightFinger.setX(targetCoordinates.getX());
        curRightFinger.setY(targetCoordinates.getY());
      } else {
        int leftDistance = distance(curLeftFinger.getX(), curLeftFinger.getY(), targetCoordinates.getX(), targetCoordinates.getY());
        int rightDistance = distance(curRightFinger.getX(), curRightFinger.getY(), targetCoordinates.getX(), targetCoordinates.getY());

        if (leftDistance == rightDistance) {
          if (hand.equals("left")) {
            sb.append("L");
            curLeftFinger.setX(targetCoordinates.getX());
            curLeftFinger.setY(targetCoordinates.getY());
          } else { // hand = "right"
            sb.append("R");
            curRightFinger.setX(targetCoordinates.getX());
            curRightFinger.setY(targetCoordinates.getY());
          }
        } else if (leftDistance < rightDistance) {
          sb.append("L");
          curLeftFinger.setX(targetCoordinates.getX());
          curLeftFinger.setY(targetCoordinates.getY());
        } else {
          sb.append("R");
          curRightFinger.setX(targetCoordinates.getX());
          curRightFinger.setY(targetCoordinates.getY());
        }
      }
    }

    return sb.toString();
  }

  private static int distance(int x, int y, int numX, int numY) {
    return Math.abs(numX - x) + Math.abs(numY - y);
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
