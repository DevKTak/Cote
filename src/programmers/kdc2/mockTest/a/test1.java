package programmers.kdc2.mockTest.a;

public class test1 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{4, 9, 5, 8}, 2, 3, 3));
  }

  private static int solution(int[] monster, int S1, int S2, int S3) {
    int sum, totalCnt = 0, resultCnt = 0;

    for (int i = 1; i <= S1; i++) {
      for (int j = 1; j <= S2; j++) {
        for (int k = 1; k <= S3; k++) {
          sum = i + j + k;
          totalCnt++;

          for (int m : monster) {
            if (1 + sum == m) {
              resultCnt++;
              break;
            }
          }
        }
      }
    }
    System.out.println("resultCnt = " + resultCnt);
    System.out.println("totalCnt = " + totalCnt);

    double doubleResult = (double) (totalCnt - resultCnt) / totalCnt;
    System.out.println("doubleResult = " + doubleResult);

    int intResult = (int) (doubleResult * 1000);
    System.out.println("intResult = " + intResult);

    return intResult;
  }
}
