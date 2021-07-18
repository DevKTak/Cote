package programmers.level1;

public class 소수만들기 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 7 ,6, 4};
    System.out.println(solution(nums)); // 4
  }

  private static int solution(int[] nums) {
    int sum = 0;

    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          sum += isPrimeNumber(nums[i] + nums[j] + nums[k]) ? 1 : 0;
        }
      }
    }

    return sum;
  }

  private static boolean isPrimeNumber(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) return false;
    }

    return true;
  }
}
