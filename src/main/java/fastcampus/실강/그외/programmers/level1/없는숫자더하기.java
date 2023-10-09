package fastcampus.실강.그외.programmers.level1;

import java.util.Arrays;

public class 없는숫자더하기 {

	public static void main(String[] args) {
		없는숫자더하기 P = new 없는숫자더하기();
		System.out.println(P.solution(new int[] {1, 2, 3, 4, 6, 7, 8, 0}));
	}

	public int solution(int[] numbers) {
/*		int answer = 0;
		Map<Integer, Boolean> map = new HashMap<>();

		for (int n : numbers) {
			map.put(n, true);
		}
		for (int i = 0; i <= 9; i++) {
			if (map.get(i) == null) {
				answer += i;
			}
		}
		return answer;*/
		return 45 - Arrays.stream(numbers).sum();
	}
}
