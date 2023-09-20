package fastcampus.실강.해시;

import java.util.HashMap;
import java.util.Map;

public class 학급회장 {

	public char solution(String s) {
		char answer = ' ';
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1); // <A, 3>, <B, 3>, <C, 5>
		}
		int max = Integer.MIN_VALUE;

		for (char key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		학급회장 T = new 학급회장();
		System.out.println(T.solution("BACBACCACCBDEDE"));
		System.out.println(T.solution("AAAAABBCCDDDD"));
		System.out.println(T.solution("AABBCCDDEEABCB"));
	}
}
