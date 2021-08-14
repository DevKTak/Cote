package programmers.level2;

import java.math.BigInteger;

public class 멀쩡한사각형 {

  public static void main(String[] args) {
    int W = 8;
    int H = 12;
    System.out.println(solution(W, H));
  }

  private static long solution(int w, int h) {
    /**
     * 대각선이 지나는 단위 정사각형 공식
     *  W + H - (W, H 의 최대공약수(GCD))
     */
//    return ((long) w * h) - (w + h - (getGCD(w, h)));

    /**
     * GCD 내장함수 사용하여 구하는 법
     */
    return ((long) w * h) - (w + h - (BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue()));
  }

  /**
   * 유클리드 호제법
   */
  private static int getGCD(int w, int h) {
    int mod = w % h;

    if (mod == 0) {
      return h;
    }

    return getGCD(h, mod);
  }
}
