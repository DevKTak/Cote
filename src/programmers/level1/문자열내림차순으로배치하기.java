package programmers.level1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

  public static void main(String[] args) {
    String s = "Zbcdefg";

    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder(new String(arr));

    System.out.println(sb.reverse().toString());
  }
}
