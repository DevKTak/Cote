package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 최대값과최솟값 {

	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));
		System.out.println(solution("-1 -3 -4 -2"));
	}

	private static String solution(String s) {
		String[] arr = s.split(" ");
		Arrays.sort(arr, Comparator.comparingInt(Integer::parseInt));

		return arr[0] + " " + arr[arr.length - 1];
	}
}
