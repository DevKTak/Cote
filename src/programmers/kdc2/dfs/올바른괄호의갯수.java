package programmers.kdc2.dfs;

import java.util.Stack;

public class 올바른괄호의갯수 {

  public static int dfsCnt = 0;

  static class P {

    int open;
    int close;

    public P(int open, int close) {
      this.open = open;
      this.close = close;
    }
  }

  public static void main(String[] args) {
    /** 방법 1 **/
    dfs(new P(0, 0), 2);
    System.out.println(dfsCnt);

    /** 방법 2 **/
    System.out.println(solution(2));
  }

  /** 방법 1 **/
  private static void dfs(P p, int n) {
    if (p.open > n) return;
    if (p.close > p.open) return;
    if (p.open + p.close == 2 * n) {
      dfsCnt++;
      return;
    }
    dfs(new P(p.open, p.close + 1), n);
    dfs(new P(p.open + 1, p.close), n);
  }

  /** 방법 2 **/
  private static int solution(int n) {
    int answer = 0;
    Stack<P> stack = new Stack<>();
    stack.push(new P(0, 0));

    while (!stack.isEmpty()) {
      P p = stack.pop();

      if (p.open > n) continue;
      if (p.close > p.open) continue;
      if (p.open + p.close == 2 * n) {
        answer++;
        continue;
      }

      stack.push(new P(p.open, p.close + 1));
      stack.push(new P(p.open + 1, p.close));
    }

    return answer;
  }
}
