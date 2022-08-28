package codility.Lesson5_Prefix_Sums;

public class PassingCars {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 0, 1, 1}));
    }

    public static int solution(int[] A) {
        int result = 0;
        int curSum = 0;

        for (int v : A) {
            if (v == 0) {
                curSum++;
            } else {
                result += curSum;
            }

            if (result > 1000000000) {
                return -1;
            }
        }

        return result;
    }
}
