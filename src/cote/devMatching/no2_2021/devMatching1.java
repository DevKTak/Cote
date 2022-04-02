package cote.devMatching.no2_2021;

import java.util.Arrays;

public class devMatching1 {

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"card", "ace13", "ace16", "banker", "ace17", "ace14"}, "ace15"));
    System.out.println(solution(new String[]{"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"}, "cow"));
    System.out.println(solution(new String[]{"bird99", "bird98", "bird101", "gotoxy"}, "bird98"));
    System.out.println(solution(new String[]{"apple1", "orange", "banana3"}, "apple"));
  }

  private static String solution(String[] registered_list, String new_id) {
    Arrays.sort(registered_list);
    String S = new_id.replaceAll("[0-9]", "");
    String strN = new_id.replaceAll("[^0-9]", "");
    int N = 0;

    if (!strN.equals("")) {
      N = Integer.parseInt(strN);
    }

    while (Arrays.binarySearch(registered_list, new_id) > -1) { // 이미 존재하면
      N += 1;
      new_id = S + N;
    }

    return new_id;
  }
}
