package ndb.정렬;

import java.util.Arrays;

/**
 * 가장 작은 원소의 인덱스를 찾아서 앞으로 땡기면서 스왑하는 방식
 *
 * [시간 복잡도]
 * 최선의 경우: O(N²), 최악의 경우: O(N²)
 */
public class 선택정렬 {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i; // 가장 작은 원소의 인덱스

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
