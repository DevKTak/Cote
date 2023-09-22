package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD", "AABB"})));
		System.out.println(Arrays.toString(solution(new String[] {"AA"}, new String[] {"B"})));
	}

	private static int[] solution(String[] keymap, String[] targets) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < keymap.length; i++) {
			for (int j = 0; j < keymap[i].length(); j++) {
				// char cur = keymap[i].charAt(j);
				//
				// if (map.containsKey(cur)) {
				// 	int min = Math.min(map.get(cur), j + 1);
				// 	map.put(cur, min);
				// } else {
				// 	map.put(cur, j + 1);
				// }
				map.put(keymap[i].charAt(j), Math.min(j + 1, map.getOrDefault(keymap[i].charAt(j), Integer.MAX_VALUE)));
			}
		}
		int[] result = new int[targets.length];
		int cnt;
		boolean isMake;

		for (int i = 0; i < targets.length; i++) {
			cnt = 0;
			isMake = true;

			for (char cur : targets[i].toCharArray()) {
				if (map.containsKey(cur)) {
					cnt += map.get(cur);
				} else {
					isMake = false;
					break;
				}
			}
			result[i] = isMake ? cnt : -1;
		}
		return result;
	}
}
