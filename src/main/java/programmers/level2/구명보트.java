package programmers.level2;

import java.util.Arrays;

public class 구명보트 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
	}

	private static int solution(int[] people, int limit) {
		Arrays.sort(people);
		int cnt = people.length;

		for (int i = 0; i < people.length - 1; i++) {
			boolean flag = false;

			for (int j = i + 1; j < people.length; j++) {
				if (people[i] + people[j] <= limit) {
					flag = true;
					break;
				}
			}

			if (flag) {
				cnt--;
			}
		}
		return cnt;
	}
}
