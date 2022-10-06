package cote.tmap;

public class tmap5 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{3, -1, 0, 4}));
        System.out.println(solution(new int[]{-4, -1, 2, -3}));
    }

    private static int solution(int[] s) {
        boolean flag = false; // false: 증가 | true: 감소
        int cnt = 0;

        for (int i = 0; i < s.length - 1; i++) {
            if (!flag) {
                if (s[i] > s[i + 1]) {
                    cnt++;
                    continue;
                }
            } else {
                if (s[i] < s[i + 1]) {
                    cnt++;
                    continue;
                }
            }
            flag = !flag;
        }

        return cnt;
    }
}
