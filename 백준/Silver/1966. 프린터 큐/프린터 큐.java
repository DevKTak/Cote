import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> indexQueue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                queue.offer(Integer.parseInt(st.nextToken())); // 중요도
                indexQueue.offer(i); // 인덱스
            }
            System.out.println(solve(M, queue, indexQueue));
        }
    }

    private static int solve(int m, Queue<Integer> queue, Queue<Integer> indexQueue) {
        int count = 0;
        int max;

        while (!queue.isEmpty()) {
            max = Collections.max(queue);

            if (queue.peek() == max) {
                if (m == indexQueue.peek()) {
                    count++;
                    break;
                }
                count++;
                queue.poll();
                indexQueue.poll();
            } else {
                queue.offer(queue.poll());
                indexQueue.offer(indexQueue.poll());
            }
        }

        return count;
    }
}
