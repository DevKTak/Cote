package fastcampus.tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 가운데를 말해요
 */
public class boj_01655_가운데를말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int val = sc.nextInt();

			if (maxPQ.size() == minPQ.size()) {
				maxPQ.offer(val);
			} else {
				minPQ.offer(val);
			}

			if (!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
				minPQ.offer(maxPQ.poll());
				maxPQ.offer(minPQ.poll());
			}
			sb.append(maxPQ.peek() + System.lineSeparator());
		}
		System.out.println(sb);
	}
}
