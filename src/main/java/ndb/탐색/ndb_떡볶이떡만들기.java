package ndb.탐색;

import java.util.Arrays;

public class ndb_떡볶이떡만들기 {

    private static int n = 4;
    private static int m = 6;
    private static int[] arr = {19, 15, 10, 17};

    public static void main(String[] args) {
        int start = 0;
        int end = Arrays.stream(arr).max().orElse(0);
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int riceCake = 0;

            // 잘랐을 때의 떡의 양 계산
            for (int v : arr) {
                if (v > mid) {
                    riceCake += v - mid;
                }
            }

            if (riceCake >= m) { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색), 높이가 높을수록 덜 자르는거임
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            } else { // 목표 m 보다 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                end = mid - 1;
            }
        }

        System.out.println("적어도 m 만큼의 떡을 얻기 위한 높이의 최댓값: " + result);
    }
}
