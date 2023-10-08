package fastcampus.실강.해시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 카카오 공채 1번
 */
public class 신고결과받기 {

	public static void main(String[] args) {
		신고결과받기 P = new 신고결과받기();
		System.out.println(Arrays.toString(P.solution(new String[] {"muzi", "frodo", "apeach", "neo"},
			new String[] {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
		System.out.println(Arrays.toString(P.solution(new String[] {"con", "ryan"},
			new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
	}

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Set<String> distinctReport = new HashSet<>(Arrays.asList(report)); // report 중복 제거
		Map<String, List<String>> reportListMap = new HashMap<>(); // key: 신고당한 사람, value: [신고한 사람]
		Map<String, Integer> result = new HashMap<>();

		for (String s : distinctReport) {
			String[] split = s.split(" ");
			String start = split[0]; // 신고한 사람
			String end = split[1]; // 신고당한 사람

			List<String> startList = reportListMap.getOrDefault(end, new ArrayList<>());
			startList.add(start); // 신고한 사람 리스트
			reportListMap.put(end, startList);
		}
		for (String end : reportListMap.keySet()) {
			List<String> startList = reportListMap.get(end);// 신고한 사람 리스트

			if (startList.size() >= k) { // 정지 기준이 되는 신고 횟수 k 이상이면
				for (String start : startList) {
					result.put(start, result.getOrDefault(start, 0) + 1);
				}
			}
		}
		for (int i = 0; i < id_list.length; i++) {
			answer[i] = result.getOrDefault(id_list[i], 0);
		}
		return answer;
	}
}
