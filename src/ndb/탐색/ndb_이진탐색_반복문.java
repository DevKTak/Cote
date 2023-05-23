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
    }

    public static void main(String[] args) {
        int result = binarySearch(0, n - 1);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("원소가 존재하지 않습니다.");
        }
    }
}
