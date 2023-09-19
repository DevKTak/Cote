import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
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