package programmers.level2;

import java.util.Arrays;

public class 구명보트 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
		System.out.println(solution(new int[] {50, 70, 80}, 100));
	}

	private static int solution(int[] people, int limit) {
		int leftIndex = 0;
		int cnt = 0;

		Arrays.sort(people); // 50, 70, 80

		for (int rightIndex = people.length - 1; rightIndex >= leftIndex; rightIndex--) {
			if (people[leftIndex] + people[rightIndex] <= limit) {
				leftIndex++;
			}
			cnt++;
		}
		return cnt;
	}
}
