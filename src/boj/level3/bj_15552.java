package boj.level3;

import java.io.*;
import java.util.StringTokenizer;

public class bj_15552 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
    StringTokenizer st;

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int sum = A + B;

      bw.write(sum + "\n");
    }
    bw.flush();
  }
}
