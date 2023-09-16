package programmers.level2;

import java.util.Arrays;

public class 카펫 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(12, 3)));
		System.out.println(Arrays.toString(solution(8, 8)));
	}

	private static int[] solution(int brown, int yellow) {
		int[] result = new int[2];
		int total = brown + yellow;

		for (int col = 1; col <= Math.sqrt(total); col++) {
			if (total % col == 0) {
				int row = total / col;

				if ((row - 2) * (col - 2) == yellow) {
					result[0] = row;
					result[1] = col;

					break;
				}
			}
		}
		return result;
	}
}
