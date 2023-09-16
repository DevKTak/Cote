package programmers.level2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class 영어끝말잇기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
		System.out.println(Arrays.toString(solution(5,
			new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
				"establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
	}

	private static int[] solution(int n, String[] words) {
		Set<String> set = new LinkedHashSet<>(); // 중복 허용 X, [순서 보장 O]
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
