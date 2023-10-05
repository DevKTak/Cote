package fastcampus.실강.해시;

import java.util.HashMap;
import java.util.Map;

// PCCP 문제
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
		for (int i = 0; i < input_string.length(); i++) {
			char c = input_string.charAt(i);
			int cnt = map.get(c);

			for (int j = 0; j < cnt; j++) {
				if (c != input_string.charAt(i)) {
					sb.append(c);
					break;
				}
			}
		}
		return sb.toString();
	}
}
