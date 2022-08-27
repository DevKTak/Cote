package codility.Lesson2_Arrays;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }

    private static int solution(int[] A) {
            Map<Integer, Integer> map = new HashMap<>();

//            Arrays.stream(A).forEach((v) -> map.put(v, map.getOrDefault(v, 0) + 1));
            for (int i = 0; i < A.length; i++) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            }

            for (int key : map.keySet()) {
                if (map.get(key) % 2 == 1) {
                   return key;
                }
            }

            return -1;
    }
}
