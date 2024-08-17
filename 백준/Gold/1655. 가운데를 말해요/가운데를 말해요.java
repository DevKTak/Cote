

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> descPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> ascPQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (descPQ.size() == ascPQ.size()) {
                if (!ascPQ.isEmpty() && ascPQ.peek() < num) {
                    int temp = ascPQ.remove();
                    ascPQ.offer(num);
                    descPQ.offer(temp);
                } else {
                    descPQ.offer(num);
                }
            } else {
                if (!descPQ.isEmpty() && descPQ.peek() > num) {
                    int temp = descPQ.remove();
                    descPQ.offer(num);
                    ascPQ.offer(temp);
                } else {
                    ascPQ.offer(num);
                }
            }
            sb.append(descPQ.peek()).append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
