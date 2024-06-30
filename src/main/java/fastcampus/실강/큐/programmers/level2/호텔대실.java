package fastcampus.실강.큐.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 호텔대실 {

	public static void main(String[] args) {
		호텔대실 test = new 호텔대실();
		System.out.println(
			test.solution(
				new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},
					{"18:20", "21:20"}}));

	}

	class Booking /*implements Comparable*/ {

		private int checkIn;
		private int checkOut;

		public Booking(String checkIn, String checkOut) {
			this.checkIn = calcMinute(checkIn);
			this.checkOut = calcMinute(checkOut);
		}

		private int calcMinute(String time) {
			String[] split = time.split(":");

			return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		}

		// @Override
		// public int compareTo(Booking o) {
		// 	return this.checkIn - o.checkIn;
		// 	// return this.checkOut - o.checkOut;
		// }

		@Override
		public String toString() {
			return "Booking{" +
				"checkIn=" + checkIn +
				", checkOut=" + checkOut +
				'}';
		}
	}

	/**
	 * 		compare return	 |    설명
	 * 	    ------------------------------------------------------------
	 *		양수			 |    첫번째 매개변수가 더 큰 값으로 판단
	 * 		0				 |    같은 값으로 판단
	 *		음수			 |    첫번째 매개변수가 더 작은 값으로 판단
	 */

	private int solution(String[][] book_time) {
		PriorityQueue<Booking> pq = new PriorityQueue<>((o1, o2) -> o1.checkIn - o2.checkIn);

		for (String[] time : book_time) {
			pq.offer(new Booking(time[0], time[1]));
		}
		// for (int i = 0; i < book_time.length; i++) {
		// 	System.out.println(pq.poll());
		// }

		List<Integer> checkOutTimes = new ArrayList<>();

		while (!pq.isEmpty()) {
			Booking booking = pq.poll();
			int checkIn = booking.checkIn;
			int checkOut = booking.checkOut;

			boolean isAvailable = false;
			Collections.sort(checkOutTimes); // 체크아웃이 가장 빠른거를 앞으로 정렬

			for (int i = 0; i < checkOutTimes.size(); i++) {
				if (checkOutTimes.get(i) + 10 <= checkIn) {
					isAvailable = true;
					checkOutTimes.set(i, checkOut);

					break;
				}
			}
			if (!isAvailable) {
				checkOutTimes.add(checkOut);
			}
		}
		return checkOutTimes.size();
	}
}
