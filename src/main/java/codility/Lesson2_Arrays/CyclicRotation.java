package codility.Lesson2_Arrays;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
    }

    private static int[] solution(int[] A, int K) {
       /* List<Integer> list = new ArrayList<>();

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

        return arr;*/

        int[] arr = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            arr[(i + K) % A.length] = A[i];
        }

        return arr;
    }
}
