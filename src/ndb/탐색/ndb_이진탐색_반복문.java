package ndb.탐색;

public class ndb_이진탐색_반복문 {

    private static int n = 10;
    private static int target = 7;
    private static int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    public static int binarySearch(int left, int right) {
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

        /*
            [교재 답안]

            while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
            }

            return -1;
        */
    }

    public static void main(String[] args) {
        int result = binarySearch(0, n - 1);

//        Arrays.sort(arr);
//        int result = Arrays.binarySearch(arr, target);


        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("원소가 존재하지 않습니다.");
        }
    }
}
