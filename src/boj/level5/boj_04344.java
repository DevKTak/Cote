package boj.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_04344 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 학생 수
            int[] arr = new int[N];
            int sum = 0;

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            int average = sum / N;

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] > average) {
                    cnt++;
                }
            }
            double answer = (double) cnt / N * 100;
            System.out.println(String.format("%.3f", answer) + "%");
        }
    }
}
