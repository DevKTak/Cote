package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_01966 {

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
        int max, curPoll, curIndexPoll;

        while (!queue.isEmpty()) {
            max = Collections.max(queue); // 현재 중요도가 가장 높은 문서
            curPoll = queue.poll(); // 현재 맨 앞 문서
            curIndexPoll = indexQueue.poll(); // 현재 맨 앞 문서의 인덱스

            if (curPoll == max) { // 인쇄 가능한 문서라면
                if (curIndexPoll == m) { // 찾으려는 문서라면
                    count++;
                    break;
                }
                count++; // 인쇄할 경우 카운트 증가
            } else { // 중요도가 가장 높은 문서가 아니라면 (인쇄 가능하지 않은 문서)
                queue.offer(curPoll); // 문서 뒤로 보내기
                indexQueue.offer(curIndexPoll); // 문서의 인덱스도 뒤로 보내기
            }
        }

        return count;
    }
}
