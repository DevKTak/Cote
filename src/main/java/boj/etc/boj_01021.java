package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_01021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = list.indexOf(target);

            while (target != list.peekFirst()) {
                if (index <= list.size() / 2) { // 찾으려는 숫자가 중간 기준 왼쪽에 있다
                    list.offerLast(list.pollFirst()); // 문제의 2번 연산 (좌측으로 한칸 이동)
                } else { // 중간 기준 오른쪽
                    list.offerFirst(list.pollLast()); // 문제의 3번 연산 (우측으로 한칸 이동)
                }
                cnt++;
            }
            list.pollFirst(); // 문제의 1번 연산
        }
        System.out.println(cnt);
    }
}
