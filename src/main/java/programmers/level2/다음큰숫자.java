package programmers.level2;

public class 다음큰숫자 {

	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}

	private static int solution(int n) {
		int nCnt = Integer.bitCount(n);

		while (true) {
			n++;

			if (nCnt == Integer.bitCount(n))
				break;
		}
		return n;
	}
}

