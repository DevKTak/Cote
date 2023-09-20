package fastcampus.실강.해시;

import java.util.HashMap;
import java.util.Map;

public class 외톨이알파벳 {

	public static void main(String[] args) {
		System.out.println(solution("edeaaabbccd"));
	}

	private static String solution(String input_string) {
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();

		for (char c : input_string.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int i = 1; i < input_string.length() - 1; i++) {
			if (map.get(input_string.charAt(i)) >= 2) {
				if (input_string.charAt(i - 1) != input_string.charAt(i)
					&& input_string.charAt(i) != input_string.charAt(i + 1)) {
					sb.append(input_string.charAt(i));
				}
			}
		}
		return sb.toString();
	}
}
