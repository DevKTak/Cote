import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

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
            boolean flag = false;

            for (int j = 0; j <= list.size() / 2; j++) {
                if (target == list.get(j)) {
                    flag = true;
                    break;
                }
            }

            if (flag) { // 중간 기준 왼쪽
                while (target != list.peekFirst()) {
                    list.offerLast(list.pollFirst());
                    cnt++;
                }
                list.pollFirst();
            } else { // 중간 기준 오른쪽
                while (target != list.peekLast()) {
                    list.offerFirst(list.pollLast());
                    cnt++;
                }
                list.offerFirst(list.pollLast());
                list.pollFirst();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
