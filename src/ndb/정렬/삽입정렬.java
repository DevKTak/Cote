package ndb.정렬;

import java.util.Arrays;

/**
 * i 인덱스의 좌측은 정렬 되어있다고 가정한 상태로 검사하여 삽입하는 방식
 */
public class 삽입정렬 {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < arr.length; i++) {

            // 인덱스 i부터 1까지 감소하며 반복하는 문법
            for (int j = i; j > 0; j--) { // 0 번 인덱스는 정렬 되어있다고 가정하에 시작이기 때문에 (j > 0)

                // 한 칸씩 왼쪽으로 이동
                if (arr[j - 1] > arr[j]) {

                    // Swap
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else { // 자기보다 작은 데이터를 만나면 그 앞에는 이미 정렬되어 있기 때문에 더 검사하는 의미가 없음
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
