package ndb.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ndb_상하좌우 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int x = 1;
        int y = 1;
        int[] dx = {0, 0, -1 ,1}; // row == y축으로 위쪽아래쪽 == 행
        int[] dy = {-1, 1, 0, 0}; // column == x축 왼쪽오른쪽 == 열
        char[] moveType = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (char ch : arr) {
            for (int i = 0; i < moveType.length; i++) {
                int nx;
                int ny;

                if (ch == moveType[i]) {
                    nx = x + dx[i];
                    ny = y + dy[i];

                    // N * N 공간안에 있을 경우에만 계산
                    if (nx <= n && ny <= n && nx > 0 && ny > 0) {
                        x = nx;
                        y = ny;
                    }

                    // L R U D 중 일치해서 for 문안에 들어온거니깐 나머지 다 확인할 필요없을것 같아서 break;
                    break;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
