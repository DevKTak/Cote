package cote.cj;

import java.util.ArrayList;

public class cj2 {

  static ArrayList<Integer>[] adList; // 인접 리스트(Adjacency-list)

  public static void main(String[] args) {
    String[] subway = {"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"};
    int start = 1;
    int end = 9;
    System.out.println(solution(subway, start, end)); // 1
  }

  private static int solution(String[] subway, int start, int end) {
    return 0;
  }
}
