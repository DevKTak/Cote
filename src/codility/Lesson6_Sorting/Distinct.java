package codility.Lesson6_Sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1}));
        System.out.println(solution(new int[]{}));

        System.out.println(solution2(new int[]{2, 1, 1, 2, 3, 1}));
        System.out.println(solution2(new int[]{}));
    }

    private static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int v : A) {
            set.add(v);
        }

        return set.size();
    }

    private static int solution2(int[] A) {
        if (A.length == 0) return 0;

        Arrays.sort(A);
        int sum = 1;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                sum++;
            }
        }

        return sum;
    }
}
