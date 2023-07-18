package programmers.level1;

import java.util.Arrays;

public class 서울에서김서방찾기 {

  public static void main(String[] args) {
    String[] seoul = {"Jane", "Kim", "Kim"};

    System.out.println("김서방은 " + Arrays.asList(seoul).indexOf("Kim") +"에 있다");
  }
}
