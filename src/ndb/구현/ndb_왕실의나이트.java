package ndb.구현;

import java.util.Scanner;

public class ndb_왕실의나이트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // 나이트가 이동할 수 있는 8 가지 방향 정의 (하, 좌, 상, 우 순으로 작성했음)
        int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1}; // row == y축으로 위쪽아래쪽 == 행
        int[] dy = {-1, 1, -2, -2, -1, 1, 2, 2}; // column == x축 왼쪽오른쪽 == 열

        int row = s.charAt(1) - '0' - 1;
        int column = s.charAt(0) - 'a';

        System.out.println("row = " + row);
        System.out.println("column = " + column);

        int count = 0;
        int nx, ny;

        for (int i = 0; i < 8; i++) {
            nx = row + dx[i];
            ny = column + dy[i];

            if (nx >= 0 && ny >= 0 && nx <= 7 && ny <= 7) {
                count++;
            }
        }
        System.out.println(count);
    }
}
