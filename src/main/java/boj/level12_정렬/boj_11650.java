package boj.level12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좌표 정렬하기
 */
public class boj_11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Location[] arr = new Location[N];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Location(x, y);
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i].x + " " + arr[i].y);
        }
        System.out.println(Arrays.toString(arr));
    }

    static class Location implements Comparable<Location> {

        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x == o.x) {
                return this.y - o.y;
//                if (this.y > o.y) {
//                    return 1;
//                } else if (this.y == o.y) {
//                    return 0;
//                } else {
//                    return -1;
//                }
            } else {
                return -1;
            }
        }
    }


}
