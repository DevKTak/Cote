package programmers.level1;

import java.util.Arrays;

public class 비밀지도 {

  public static void main(String[] args) {
    int n = 6;
    int[] arr1 = {46, 33, 33 ,22, 31, 50};
    int[] arr2 = {27 ,56, 19, 14, 14, 10};
    System.out.println(Arrays.toString(solution(n, arr1, arr2))); // ["######", "### #", "## ##", " #### ", " #####", "### # "]
  }

  private static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i = 0; i < n; i++) {
      String binary1 = Integer.toBinaryString(arr1[i]);
      String binary2 = Integer.toBinaryString(arr2[i]);
      int zeroCnt1 = n - binary1.length();
      int zeroCnt2 = n - binary2.length();
      String zeroSumTemp = "";

      if (zeroCnt1 > 0) {
        for (int j = 0; j < zeroCnt1; j++) {
          zeroSumTemp += "0";
        }
        zeroSumTemp += binary1;
        binary1 = zeroSumTemp;
      }
      zeroSumTemp = "";

      if (zeroCnt2 > 0) {
        for (int j = 0; j < zeroCnt2; j++) {
          zeroSumTemp += "0";
        }
        zeroSumTemp += binary2;
        binary2 = zeroSumTemp;
      }
      System.out.println("binary1 = " + arr1[i] + "( " + binary1 + " )");
      System.out.println("binary2 = " + arr2[i] + "( " + binary2 + " ) \n");

      oRoperation(i, binary1, binary2, answer);
    }

    return answer;
  }

  private static void oRoperation(int i, String binary1, String binary2, String[] answer) {
    StringBuilder oRTempSb = new StringBuilder();

    for (int j = 0; j < binary1.length(); j++) {
      if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
        oRTempSb.append("#");
      } else {
        oRTempSb.append(" ");
      }
      answer[i] = oRTempSb.toString();
    }
  }
}
