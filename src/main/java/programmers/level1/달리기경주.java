package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class 달리기경주 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			solution(new String[] {"mumu", "soe", "poe", "kai", "mine"}, new String[] {"kai", "kai", "mine", "mine"})));
		System.out.println(Arrays.toString(
			solution2(new String[] {"mumu", "soe", "poe", "kai", "mine"},
				new String[] {"kai", "kai", "mine", "mine"})));
	}

	// 시간 초과
	private static String[] solution(String[] players, String[] callings) {
		for (String calling : callings) {
			int index = IntStream.range(0, players.length)
				.filter(i -> players[i].equals(calling))
				.findFirst()
				.orElseThrow();

			String temp = players[index - 1];
			players[index - 1] = players[index];
			players[index] = temp;
		}
		return players;
	}

	private static String[] solution2(String[] players, String[] callings) {
		Map<String, Integer> rank = new HashMap<>(); // <mumu, 0> <soe, 1> <poe, 2>, <kai, 3> ...

		for (int i = 0; i < players.length; i++) {
			rank.put(players[i], i);
		}

		for (String callingPlayer : callings) {
			int callingPlayerRank = rank.get(callingPlayer); // 불린 선수의 등수
			String beforePlayer = players[callingPlayerRank - 1]; // 앞에 선수

			// 선수 배열 갱신
			players[callingPlayerRank - 1] = callingPlayer;
			players[callingPlayerRank] = beforePlayer;

			// 등수 맵 갱신
			rank.put(callingPlayer, callingPlayerRank - 1);
			rank.put(beforePlayer, callingPlayerRank);
		}
		return players;
	}
}
