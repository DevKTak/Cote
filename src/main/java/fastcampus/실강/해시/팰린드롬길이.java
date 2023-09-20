package fastcampus.실강.해시;

import java.util.HashMap;
import java.util.Map;

public class 팰린드롬길이 {

	public int solution(String s) {
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1); // <a, 3>, <b, 4> ...
		}
		int oddCnt = 0;

		for (char key : map.keySet()) {
			if (map.get(key) % 2 == 1) { // 홀수면
				oddCnt++;
			}
		}
		return oddCnt > 0 ? s.length() - oddCnt + 1 : s.length();
	}

	public static void main(String[] args) {
		팰린드롬길이 T = new 팰린드롬길이();
		System.out.println(T.solution("abcbbbccaaeee"));
		System.out.println(T.solution("aabbccddee"));
		System.out.println(T.solution("fgfgabtetaaaetytceefcecekefefkccckbsgaafffg"));
		System.out.println(T.solution("aabcefagcefbcabbcc"));
		System.out.println(T.solution("abcbbbccaa"));
	}
}
