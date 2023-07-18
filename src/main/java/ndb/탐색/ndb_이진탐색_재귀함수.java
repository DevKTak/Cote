package ndb.탐색;

public class ndb_이진탐색_재귀함수 {

    private static int n = 10;
    private static int target = 7;
    private static int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    private static int binarySearch(int start, int end) {
        // 종료 조건
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(start, mid - 1);
        } else {
            return binarySearch(mid + 1, end);
        }
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
