package codility.Lesson4_Sorting;

import java.util.HashSet;
import java.util.Set;

public class ForgRiverOne {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }


    // 몇 초 걸리는지?
    public static int solution(int X, int[] A) {
        Set<Integer> hashSet = new HashSet<>();
        int second = -1;

        for (int i = 0; i < A.length; i++) {
            hashSet.add(A[i]);

            if (hashSet.size() == X) {
                second = i;
                break;
            }
        }

        return second;
    }
}
