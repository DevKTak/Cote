package programmers.level2;

import java.util.*;

/* 문자열 전체 비교를 하면서 노가다를 해야할 것 같은 이런 문제유형일 경우 해시를 떠올리자! */
public class 전화번호목록 {

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
  }

  private static boolean solution(String[] phone_book) {
    /*Map<String, String> map = new HashMap<>();

    for (String s : phone_book) {
      map.put(s, s);
    }

    for (int i = 0; i < phone_book.length; i++) {
      for (int j = 1; j < phone_book[i].length(); j++) {
        if (map.containsValue(phone_book[i].substring(0, j))) return false;
      }
    }

    return true;*/

    Set<String> set = new HashSet<>();
    set.addAll(Arrays.asList(phone_book));

    for (String phone : phone_book)
      for (int i = 1; i < phone.length(); i++)
        if (set.contains(phone.substring(0, i))) return false;

    return true;
  }
}
