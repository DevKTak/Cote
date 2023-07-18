package ndb.정렬;

/**
 * 가장 대표적인 분할 방식인 호어 분할방식을 기준의 퀵 정렬 알고리즘
 *
 * [시간 복잡도]
 * 최선의 경우: O(NlogN), 최악의 경우: O(NlogN)
 */
public class ndb_퀵정렬 {

    private static int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void quickSort(int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료

        int pivot = start; // 피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;

        while (left <= right) {

            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;

            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;

            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }

            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        // 작은 데이터인 right와 피벗을 교체 했기때문에 피벗값이 들어간 right 기준으로 좌/우 나눔
        quickSort(start, right - 1);
        quickSort(right + 1, end);
    }

    public static void main(String[] args) {
        int n = 10;

        quickSort(0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
