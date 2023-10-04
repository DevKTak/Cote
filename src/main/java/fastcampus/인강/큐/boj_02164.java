package fastcampus.인강.큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_02164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if (N == 1) {
			System.out.println(1);
			System.exit(0);
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.offer(i + 1);
		}

		// 나의 풀이
		//        while (N-- > 1) {
		//            queue.poll();
		//
		//            if (queue.size() == 1) {
		//                System.out.println(queue.peek());
		//                break;
		//            }
		//            queue.offer(queue.poll());
		//        }

		int count = 1;

		while (queue.size() != 1) {
			int poll = queue.poll();

			if (count % 2 == 0) {
				queue.offer(poll);
			}
			count++;
		}
		System.out.println(queue.peek());
	}
}
