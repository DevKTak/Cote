package programmers.level2;

import java.util.Arrays;

public class 이진변환반복하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001")));
		System.out.println(Arrays.toString(solution("01110")));
		System.out.println(Arrays.toString(solution("1111111")));
	}

	private static int[] solution(String s) {
		int binaryConversionCnt = 0;
		int zeroRemoveCnt = 0;

		while (!s.equals("1")) {
			int oneCnt = (int)s.chars().filter(ch -> ch == '1').count();
			zeroRemoveCnt += s.length() - oneCnt;

			s = Integer.toBinaryString(oneCnt);
			binaryConversionCnt++;
		}
		return new int[] {binaryConversionCnt, zeroRemoveCnt};
	}
}
