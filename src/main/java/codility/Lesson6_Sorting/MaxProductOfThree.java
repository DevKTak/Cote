package codility.Lesson6_Sorting;

import java.util.Arrays;

public class MaxProductOfThree {

    public static void main(String[] args) {
        System.out.println(solutionDesc(new int[]{-3, 1, 2, -2, 5, 6})); // 60
        System.out.println(solutionDesc(new int[]{-5, 5, -5, 4}));
        System.out.println(solutionDesc(new int[]{-5, -6, -4, -7, -10})); // -120

        System.out.println(solutionAsc(new int[]{-3, 1, 2, -2, 5, 6})); // 60
        System.out.println(solutionAsc(new int[]{-5, -6, -4, -7, -10})); // -120
    }

    /**
     * 형변환 코드 추가되면 시간초과 (for문으로 해도 마찬가지)
     */
    private static int solutionDesc(int[] A) {
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (v1, v2) -> v2 - v1);

        int second = arr[1] * arr[2];
        int end = arr[arr.length - 1] * arr[arr.length - 2];

        return arr[0] * (arr[0] < 0 ?  second : Math.max(second, end));
    }

    private static int solutionAsc(int[] A) {
        Arrays.sort(A);

        int length = A.length;
        int firstProduct = A[0] * A[1];
        int lastProduct = A[length - 3] * A[length - 2];
        int lastElement = A[length - 1];

        return lastElement * (lastElement < 0 ? lastProduct : Math.max(firstProduct, lastProduct));
    }
}
