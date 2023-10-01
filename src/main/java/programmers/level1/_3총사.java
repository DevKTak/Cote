package programmers.level1;

public class _3총사 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {-2, 3, 0, 2, -5}));
		System.out.println(solution(new int[] {-3, -2, -1, 0, 1, 2, 3}));
	}

	private static int solution(int[] number) {
		int cnt = 0;

		for (int i = 0; i < number.length - 2; i++) {
			for (int j = i + 1; j < number.length - 1; j++) {
				for (int k = j + 1; k < number.length; k++) {
					if (number[i] + number[j] + number[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
