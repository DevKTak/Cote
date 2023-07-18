package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

  public static void main(String[] args) {
    String[] participant = {"mi", "st", "mi", "ana"};
    String[] completion = {"st", "ana", "mi"};
    Map<String, Integer> map = new HashMap<>();

    for (String part : participant) {
      if (map.get(part) != null) {
        map.put(part, map.get(part) + 1);
      } else {
        map.put(part, 1);
      }
    }

    for (String comp : completion) {
      map.put(comp, map.get(comp) - 1);
    }

    for (String key : map.keySet()) {
      if (map.get(key) != 0) {
        System.out.println(key);
        return;
      }
    }

    /* 다른 풀이법 */
//    Arrays.sort(participant);
//    Arrays.sort(completion);
//    int i;
//    for (i = 0; i < completion.length; i++) {
//      if (!participant[i].equals(completion[i])) {
//        return participant[i];
//      }
//    }
//    return participant[i];

  }
}
