package boj.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_01110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        br.close();

        int sum = N;
        int cnt = 0;

        while (true) {
            int front = sum / 10;
            int back = sum % 10;
            int sumBack = (front + back) % 10;
            sum = (back * 10) + sumBack;
            cnt++;

            if (sum == N) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
