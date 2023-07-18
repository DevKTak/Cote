package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 정수내림차순으로배치하기 {

  public static void main(String[] args) {
    long n = 118372;

    /** 방법 1: */
    String nStr = String.valueOf(n);
    String[] nStrArr = nStr.split("");
    Arrays.sort(nStrArr, Comparator.reverseOrder()); // 배열 내림차순 정렬
    String nStr2 = "";

    for (String str : nStrArr) {
      nStr2 += str;
    }
    Long nLong = Long.parseLong(nStr2);
    System.out.println("nLong = " + nLong);

    /** 방법 2: */
//    String nStr = String.valueOf(n);
//    char[] nCharArr = nStr.toCharArray();
//    Arrays.sort(nCharArr);
    // String.valuOf(캐릭터 배열만 가능해서 split() 대신 toCharArray() 호출했음)
//    StringBuilder sb = new StringBuilder(String.valueOf(nCharArr));
//    sb.reverse();
//    Long nLong = Long.parseLong(sb.toString());
//    System.out.println("nLong = " + nLong);
  }
}
