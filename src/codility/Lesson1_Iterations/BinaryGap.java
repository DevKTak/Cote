package codility.Lesson1_Iterations;

public class BinaryGap {

    public static void main(String[] args) {

        System.out.println(solution(1041));
    }

    private static int solution(int N) {
        String binaryNum = Integer.toBinaryString(N);
        int maxLength = 0;
        int tempCnt = 0;

        for (int i = 1; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) == '0') {
                tempCnt++;
            } else {
                maxLength = Math.max(maxLength, tempCnt);
                tempCnt = 0;
            }
        }

        return maxLength;
    }
}
