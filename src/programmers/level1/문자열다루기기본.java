package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 문자열다루기기본 {

  public static void main(String[] args) {
    String s = "a2434";

    // 방법 1:
    System.out.println((s.length() == 4 || s.length() == 6) && s.split("[0-9]").length == 0 ? true : false);

    // 방법 2:
    System.out.println((s.length() == 4 || s.length() == 6) && s.matches("[0-9]+") ? true : false);

    // 방법 3:
    if ((s.length() == 4 || s.length() == 6)) {
      try {
        Integer.parseInt(s);
        System.out.println(true);
      } catch (Exception e) {
        e.printStackTrace();
        System.err.println("에러내용 : " + e);

        System.out.println(false);
      }
    } else {
      System.out.println(false);
    }
  }
}
