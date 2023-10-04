import java.util.*;


class Solution {
    public String solution(String X, String Y) {
	StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();

		for (char x : X.toCharArray()) {
			xMap.put(x - 48, xMap.getOrDefault(x - 48, 0) + 1);
		}
		for (char y : Y.toCharArray()) {
			yMap.put(y - 48, yMap.getOrDefault(y - 48, 0) + 1);
		}
		for (int x : xMap.keySet()) {
			if (yMap.get(x) != null) {
				for (int i = 0; i < Math.min(xMap.get(x), yMap.get(x)); i++) {
					sb.append(x);
				}
			}
		}
		// StringBuilder 내림차순
		String result = sb.reverse().toString();

		if (sb.toString().equals("")) {
			result = "-1";
		} else if (sb.charAt(0) == '0') {
			result = "0";
		}
		return result;
    }
}