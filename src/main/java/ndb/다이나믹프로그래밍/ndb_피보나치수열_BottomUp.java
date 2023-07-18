package ndb.다이나믹프로그래밍;

public class ndb_피보나치수열_BottomUp {

    public static void main(String[] args) {
        // 1 1 2 3 5 8 13 21 34 55 89
        fibonacci(11);
    }

    private static void fibonacci(int i) {
        int[] memo = new int[i + 1];
        memo[1] = 1;
        memo[2] = 1;

        for (int j = 3; j <= i; j++) {
            memo[j] = memo[j - 2] + memo[j - 1];
        }
        System.out.println(memo[i]);
    }
}
