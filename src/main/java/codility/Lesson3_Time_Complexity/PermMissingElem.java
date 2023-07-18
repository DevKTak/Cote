package codility.Lesson3_Time_Complexity;

import java.util.Arrays;

public class PermMissingElem {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3}));
    }

    private static int solution(int[] A) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int v : A) {
//            map.put(v, v);
//        }
//
//        for (int i = 1; i <= A.length + 1; i++) {
//            if (map.get(i) == null) {
//                return i;
//            }
//        }
//
//        return -1;


        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
