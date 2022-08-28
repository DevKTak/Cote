package codility.Lesson4_Sorting;

import java.util.Arrays;

public class PermCheck {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2}));
        System.out.println(solution(new int[]{4, 1, 3, 2}));
        System.out.println(solution(new int[]{4, 1 , 6, 2}));
        System.out.println(solution(new int[]{1, 2, 4, 3}));
        System.out.println(solution(new int[]{4, 1, 3, 5}));
        System.out.println(solution(new int[]{3,1}));
        System.out.println(solution(new int[]{2, 3, 4, 5}));
    }

    /**
     * 1 부터 N 까지 이루는 순열인지 맞으면 1 아니면 0
     */
    private static int solution(int[] A) {
        Arrays.sort(A);
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }
}
