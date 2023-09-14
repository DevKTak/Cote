class Solution {
    public int solution(int n) {
     int[] fibo = new int[n + 1];
		fibo[1] = fibo[2] = 1;

		for (int i = 3; i <= n; i++) {
			fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
		}
		return fibo[n];
    }
}