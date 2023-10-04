package fastcampus.인강.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * LIS(Longest Increasing Subsequence)
 */
public class boj_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] memo = new int[N];
		Arrays.fill(memo, 1);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}
		System.out.println(Arrays.stream(memo).max().getAsInt());
	}
}
