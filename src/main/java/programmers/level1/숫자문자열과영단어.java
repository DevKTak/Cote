package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {

  public static void main(String[] args) {
    String S = "one4seveneight";
    System.out.println(solution(S));
  }

  private static int solution(String s) {
    Map<String, String> map = new HashMap<>();
    map.put("0", "zero");
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", "three");
    map.put("4", "four");
    map.put("5", "five");
    map.put("6", "six");
    map.put("7", "seven");
    map.put("8", "eight");
    map.put("9", "nine");

    for (Map.Entry<String, String> elem : map.entrySet()) {
      String value = elem.getValue();
      System.out.println("value = " + value);

      String key = elem.getKey();
      System.out.println("key = " + key);

      s = s.replace(value, key);
      System.out.println("s = " + s + "\n");
    }

    return Integer.parseInt(s);
  }
}
