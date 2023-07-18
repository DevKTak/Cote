package codility.Lesson6_Sorting;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 2, 5, 1, 8, 20}));
    }

    private static int solution(int[] A) {
        if (A.length < 3) return 0;

        Arrays.sort(A);

        // sorting 후에는 P < Q < R 일 때 P + Q > R 인 지만 체크하면 되고,
        // 이는 인접한 세 인덱스로 확인하면 된다.
        for (int i = 0; i < A.length - 2; i++) {
            int P = A[i];
            int Q = A[i + 1];
            int R = A[i + 2];

            // P + Q > R은 P + Q에서 오버플로우(overflow)가 발생 할 수 있기 때문에 치환해서
            // P > R - Q로 사용!!
            if (P > R - Q) {
                return 1;
            }
        }

        return 0;
    }
}
