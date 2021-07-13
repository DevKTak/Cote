package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_02869 {

//    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        int A = scanner.nextInt(); // 낮 이동거리 5 | +2
//        int B = scanner.nextInt(); // 밤 이동거리 1 | -1
//        int V = scanner.nextInt(); // 높이 6 | 5

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V - B) / (A - B); // 최소 걸리는 일 수

        if ((V - B) % (A - B) != 0) {
            day++;
        }

        System.out.println(day);
    }
}
