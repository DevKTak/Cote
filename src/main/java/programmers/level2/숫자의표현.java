package programmers.level2;

public class 숫자의표현 {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

	private static int solution(int n) {
		int cnt = 1;

		for (int i = 1; i < n; i++) {
			int sum = i;

			for (int j = i + 1; j <= n; j++) {
				sum += j;

				if (sum == n) {
					cnt++;
					break;
				} else if (sum > n) {
					break;
				}
			}
		}
		return cnt;
	}
}
