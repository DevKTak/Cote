package cote.셀러비;

// 슬라이딩 윈도우
public class Solution1 {

	public static void main(String[] args) {
		Solution1 P = new Solution1();
		System.out.println(P.solution(new int[] {5, 1, 9, 8, 10, 5}, 3)); // 27
		System.out.println(P.solution(new int[] {10, 1, 10, 1, 1, 4, 3, 10}, 6)); // 29
	}

	public int solution(int[] estimates, int k) {
		int maxSum;
		int curSum = 0;

		for (int i = 0; i < k; i++) {
			curSum += estimates[i];
		}
		maxSum = curSum;

		for (int i = 0; i < estimates.length - k; i++) {
			curSum = curSum - estimates[i] + estimates[i + k];
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}
}
