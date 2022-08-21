package codility.Lesson1_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicRotation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{}, 0)));
    }

    private static int[] solution(int[] A, int K) {
        List<Integer> list = new ArrayList<>();

        for (int v : A) {
            list.add(v);
        }

        for (int i = 0; i < K; i++) {
            Integer temp = list.remove(list.size() - 1);
            list.add(0, temp);
        }

        int[] arr = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
