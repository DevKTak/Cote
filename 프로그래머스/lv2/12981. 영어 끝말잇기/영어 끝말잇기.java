import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
 Set<String> set = new LinkedHashSet<>();
		set.add(words[0]);
		int[] result = new int[2];

		for (int i = 1; i < words.length; i++) {
			set.add(words[i]);

			if (set.size() != i + 1 || !words[i - 1].substring(words[i - 1].length() - 1)
				.equals(words[i].substring(0, 1))) {
				result[0] = i % n + 1; // 번호
				result[1] = i / n + 1; // 차례

				break;
			}
		}
		return result;
    }
}