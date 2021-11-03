package programmers.kdc2.hash;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

  public static void main(String[] args) {
    System.out.println(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
  }

  private static int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();

    for (String[] type : clothes) {
      map.put(type[1], map.getOrDefault(type[1], 0) + 1);
    }
    int sum = 1;

    for (Integer num : map.values()) {
      sum *= num + 1; // 같은 타입 옷의 수 + 1(입지않은 경우의 수)
    }

    return sum - 1; // sum은 다 안입은 경우도 포함되어 있음
  }
}
