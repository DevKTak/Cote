package boj.level6;

public class boj_04673 {

    public static void main(String[] args) {
        int num = 0;
        boolean[] flag = new boolean[10001];

        for (int i = 1; i <= 100; i++) {
             num = d(i);
        }
    }

    public static int d(int i) {
        int sum = i;

        while (i != 0) {
            sum += i % 10; // 1의 자리
            i = i / 10;
        }

        return sum;
    }
}
