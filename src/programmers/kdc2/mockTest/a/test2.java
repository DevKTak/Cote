package programmers.kdc2.mockTest.a;

import java.util.Arrays;

public class test2 {

  public static void main(String[] args) {
    System.out.println(solution("listen", "silent"));
  }

  private static boolean solution(String a, String b) {
    String[] aArr = a.toLowerCase().split("");
    String[] bArr = b.toLowerCase().split("");

    Arrays.sort(aArr);
    Arrays.sort(bArr);

    return Arrays.toString(aArr).equals(Arrays.toString(bArr));
  }
}
