package ndb.다이나믹프로그래밍;

public class ndb_개미전사 {

    public static void main(String[] args) {
        int[] d = new int[100]; // DP 테이블
        int n = 4; // 식량창고의 개수
        int[] arr = {1, 3, 1, 5}; // 각 식량 창고에 저장된 식량의 개수

        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }
        System.out.println(d[n - 1]);
    }
}
