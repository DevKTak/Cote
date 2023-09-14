package programmers.level2;

public class 피보나치수 {

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	private static int solution(int n) {
		int[] fibo = new int[n + 1];
		fibo[1] = fibo[2] = 1;

		for (int i = 3; i <= n; i++) {
			fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
		}
		return fibo[n];
	}
}
