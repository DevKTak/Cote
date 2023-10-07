package fastcampus.실강.그외.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {

	public static void main(String[] args) {
		성격유형검사하기 P = new 성격유형검사하기();
		System.out.println(P.solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
	}

	public String solution(String[] survey, int[] choices) {
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < survey.length; i++) {
			String[] split = survey[i].split("");
			String frontChar = split[0];
			String rearChar = split[1];
			int score = Math.abs(choices[i] - 4);

			if (choices[i] < 4) {
				map.put(frontChar, map.getOrDefault(frontChar, 0) + score);
			} else {
				map.put(rearChar, map.getOrDefault(rearChar, 0) + score);
			}
		}
		sb.append(map.getOrDefault("R", 0) >= map.getOrDefault("T", 0) ? "R" : "T");
		sb.append(map.getOrDefault("C", 0) >= map.getOrDefault("F", 0) ? "C" : "F");
		sb.append(map.getOrDefault("J", 0) >= map.getOrDefault("M", 0) ? "J" : "M");
		sb.append(map.getOrDefault("A", 0) >= map.getOrDefault("N", 0) ? "A" : "N");

		return sb.toString();
	}
}
