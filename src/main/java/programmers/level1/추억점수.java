package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			solution(new String[] {"may", "kein", "kain", "radi"}, new int[] {5, 10, 1, 3},
				new String[][] {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
					{"kon", "kain", "may", "coni"}})));
	}

	private static int[] solution(String[] name, int[] yearning, String[][] photo) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			map.put(name[i], yearning[i]);
		}
		// int[] result = new int[photo.length];

		// for (int i = 0; i < photo.length; i++) {
		// 	int photoSum = 0;
		//
		// 	for (int j = 0; j < photo[i].length; j++) {
		//
		// 		if (map.containsKey(photo[i][j])) {
		// 			photoSum += map.get(photo[i][j]);
		// 		}
		// 	}
		// 	result[i] = photoSum;
		// }

		return Arrays.stream(photo)
			.mapToInt(arr -> Arrays.stream(arr)
				.filter(map::containsKey)
				.mapToInt(map::get).sum())
			.toArray();
	}
}
