package boj.level18_큐and덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_02164_카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = N; i > 0; i--) {
            dq.offer(i);
        }

        while (true) {
            dq.pollLast();

            if (dq.size() == 1) {
                System.out.println(dq.peek());
                break;
            }
            dq.offerFirst(dq.pollLast());
        }
    }
}
