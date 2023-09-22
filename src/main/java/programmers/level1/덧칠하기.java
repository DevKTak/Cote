package programmers.level1;

public class 덧칠하기 {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, new int[] {2, 3, 6}));
	}

	private static int solution(int n, int m, int[] section) {
		int start = section[0];
		int end = start + m - 1;
		int cnt = 1;

		for (int part : section) {
			if (!(start <= part && part <= end)) {
				cnt++;
				start = part;
				end = start + m - 1;
			}
		}
		return cnt;
	}
}
