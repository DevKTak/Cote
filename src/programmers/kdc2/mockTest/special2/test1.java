package programmers.kdc2.mockTest.special2;

import java.util.ArrayList;
import java.util.Arrays;

public class test1 {

  static class P {

    int open;
    int close;
    String arrow;

    public P(int open, int close, String arrow) {
      this.open = open;
      this.close = close;
      this.arrow = arrow;
    }
  }

  public static void main(String[] args) {
    dfs(new P(0, 0, ""), 3);

//    System.out.println(Arrays.toString(solution(3)));
  }

  private static String[] solution(int N) {
    String[] answer = {};



    Arrays.sort(answer);
    return answer;
  }

  private static ArrayList<String> list = new ArrayList<>();
  private static ArrayList<String> result = new ArrayList<>();

  private static void dfs(P p, int n) {
    if (p.open > n) {
      return;
    }
    if (p.close > p.open) {
      return;
    }

    if (p.open + p.close == 2 * n) {
      String str = "";

      for (String s : list) {
        str += s;
      }
      result.add(str);
      System.out.println("result = " + result);

      return;
    }

    if (!p.arrow.equals("")) {
      list.add(p.arrow);
    }
    dfs(new P(p.open, p.close + 1, ")"), n);
    if (list.size() > 0) {
      list.remove(list.size() - 1);
    }
    if (!p.arrow.equals("")) {
      list.add(p.arrow);
    }
    dfs(new P(p.open + 1, p.close, "("), n);
    if (list.size() > 0) {
      list.remove(list.size() - 1);
    }
  }
}
