package ndb.다이나믹프로그래밍;

public class ndb_바닥공사 {

    public static void main(String[] args) {
        int n = 100;
        int[] d = new int[1001];

        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + (d[i - 2] * 2)) % 796796;
        }
        System.out.println(d[n]);
    }
}
