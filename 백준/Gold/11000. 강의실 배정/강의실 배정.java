import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 강의실 배정
 */
public class Main {

	static class Lecture implements Comparable<Lecture> {

		private int startTime;
		private int endTime;

		public Lecture(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		@Override
		public int compareTo(Lecture lecture) {
			if (this.startTime > lecture.startTime) {
				return 1;
			} else if (this.startTime == lecture.startTime) {
				return this.endTime - lecture.endTime;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Lecture> lectures = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			lectures.add(new Lecture(S, T)); // 강의 시작시간 기준 오름차순, 같을 시 종료시간 기준 오름차순
		}
		Collections.sort(lectures);

		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		rooms.add(lectures.get(0).getEndTime()); // 시작시간이 제일 빠른 강의의 종료시간을 기준

		for (int i = 1; i < lectures.size(); i++) {
			Lecture lecture = lectures.get(i);

			// if (lecture.getStartTime() < rooms.peek()) { // 다음으로 시작시간이 빠른 강의가 현재 큐에 있는 강의의 종료시간보다 작으면
			// 	rooms.add(lecture.getEndTime()); // 강의실이 하나 더 필요하다, 다음 강의의 종료시간을 넣어준다.
			// } else {
			// 	// 새로운 강의실이 필요하지 않다.
			// 	rooms.poll();
			// 	rooms.add(lecture.getEndTime());
			// }

			if (lecture.getStartTime() >= rooms.peek()) {
				rooms.poll();
			}
			rooms.offer(lecture.getEndTime());
		}
		System.out.println(rooms.size());
	}
}
