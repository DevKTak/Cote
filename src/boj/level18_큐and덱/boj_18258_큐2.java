package boj.level18_큐and덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_18258_큐2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    dq.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(dq.isEmpty() ? -1 : dq.poll()).append(System.lineSeparator());
                    break;
                case "size":
                    sb.append(dq.size()).append(System.lineSeparator());
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append(System.lineSeparator());
                    break;
                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.peek()).append(System.lineSeparator());
                    break;
                case "back":
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append(System.lineSeparator());
                    break;
            }
        }
        System.out.println(sb);
    }
}
