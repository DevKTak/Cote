package fastcampus.인강.그리디;

import java.util.Scanner;

/**
 * 동전 0
 */
public class boj_11047_동전0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt(); // 목표 액수
		int[] arr = new int[N];

		while (--N >= 0) {
			arr[N] = sc.nextInt();
		}

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= K) {
				cnt += K / arr[i];
				K %= arr[i];
			}
		}
		System.out.println(cnt);
	}
}
