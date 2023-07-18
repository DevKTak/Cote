package programmers.level1;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {

  public static void main(String[] args) {
    String[] strings = {"sun", "bed", "car"};
    int n = 1;

    for (int i = 0; i < strings.length - 1; i++) {
      for (int j = i + 1; j < strings.length; j++) {
        char curChar = strings[i].charAt(n);
        char nextChar = strings[j].charAt(n);
        System.out.println("curChar : " + curChar);
        System.out.println("nextChar : " + nextChar);

        if (curChar > nextChar) {
          String temp = strings[i];
          strings[i] = strings[j];
          strings[j] = temp;
        } else if (curChar == nextChar) {
          if (strings[i].compareTo(strings[j]) > 0) { // string[i] > string[j] 보다 크면 양수, 같으면 0, 작으면 음수
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
          }
        }
      }
    }

    System.out.println(Arrays.toString(strings));

    // 다른 풀이
    /*int i = 0;
    for (; i < strings.length; i++) {
      strings[i] = strings[i].charAt(n) + strings[i];
    }
    Arrays.sort(strings);
    for (i = 0; i < strings.length; i++) {
      strings[i] = strings[i].substring(1);
    }
    System.out.println(Arrays.toString(strings));*/
  }
}
