package programmers.level2;

import java.util.Arrays;

public class 최솟값만들기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 4, 2}, new int[] {5, 4, 4}));
	}

	private static int solution(int[] A, int[] B) {
	/* 효율성 실패
		Arrays.sort(A);
		Integer[] wrapperB = Arrays.stream(B).boxed().toArray(Integer[]::new);
		Arrays.sort(wrapperB, Collections.reverseOrder()); // array 내림차순

		// Arrays.sort(B, Comparator.comparingInt(o -> (int)o).reversed()); // array 내림차순

		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i] * wrapperB[i];
		}
		return sum;*/

		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;

		for (int i = 0, j = B.length - 1; i < A.length; i++, j--) {
			sum += A[i] * B[j];
		}
		return sum;
	}
}
