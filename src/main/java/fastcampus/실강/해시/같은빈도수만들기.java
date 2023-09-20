package fastcampus.실강.해시;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 우테코 문제
public class 같은빈도수만들기 {

	public int[] solution(String s) {
		int[] answer = new int[5];
		Map<Character, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
			max = Math.max(max, map.get(c));
		}

		String abcde = "abcde";

		for (char c : abcde.toCharArray()) {
			map.putIfAbsent(c, 0);
		}

		// for (char key : map.keySet()) {
		// 	final int addNum = max - map.get(key);
		// 	switch (key) {
		// 		case 'a' -> answer[0] = addNum;
		// 		case 'b' -> answer[1] = addNum;
		// 		case 'c' -> answer[2] = addNum;
		// 		case 'd' -> answer[3] = addNum;
		// 		case 'e' -> answer[4] = addNum;
		// 	}
		// }
		for (int i = 0; i < abcde.length(); i++) {
			answer[i] = max - map.getOrDefault(abcde.charAt(i), 0);
		}
		return answer;
	}

	public static void main(String[] args) {
		같은빈도수만들기 T = new 같은빈도수만들기();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
