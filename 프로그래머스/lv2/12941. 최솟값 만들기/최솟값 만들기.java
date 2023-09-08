import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
       Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;

		for (int i = 0, j = B.length - 1; i < A.length; i++, j--) {
			sum += A[i] * B[j];
		}
		return sum;
    }
}