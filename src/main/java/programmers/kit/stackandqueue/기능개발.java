package programmers.kit.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> daysList = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			int remainWork = 100 - progresses[i];
			int days = (int)Math.ceil((double)remainWork / speeds[i]);
			daysList.add(days);
		}

		List<Integer> result = new ArrayList<>();
		int deployDay = daysList.get(0);
		int count = 1;

		for (int i = 1; i < daysList.size(); i++) {
			if (daysList.get(i) <= deployDay) {
				count++;
			} else {
				result.add(count);
				count = 1;
				deployDay = daysList.get(i);
			}
		}
		result.add(count); // 마지막 count 쌓인 작업 출력

		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
