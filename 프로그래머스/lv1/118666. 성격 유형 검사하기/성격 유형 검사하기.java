import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
     	StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < survey.length; i++) {
			String[] split = survey[i].split("");
			int score = Math.abs(choices[i] - 4);

			if (choices[i] < 4) {
				map.put(split[0], map.getOrDefault(split[0], 0) + score);
			} else {
				map.put(split[1], map.getOrDefault(split[1], 0) + score);
			}
		}
		sb.append(map.getOrDefault("R", 0) >= map.getOrDefault("T", 0) ? "R" : "T");
		sb.append(map.getOrDefault("C", 0) >= map.getOrDefault("F", 0) ? "C" : "F");
		sb.append(map.getOrDefault("J", 0) >= map.getOrDefault("M", 0) ? "J" : "M");
		sb.append(map.getOrDefault("A", 0) >= map.getOrDefault("N", 0) ? "A" : "N");

		return sb.toString();
    }
}