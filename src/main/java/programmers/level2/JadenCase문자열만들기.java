package programmers.level2;

public class JadenCase문자열만들기 {

	public static void main(String[] args) {
		System.out.println(solution("3people   unFollowed me"));
		System.out.println(solution("for the last week"));
		System.out.println(solution("for  33he 2ast 5 week"));
		System.out.println(solution("a")); // 놓친 예외 케이스
	}

	private static String solution(String s) {
		String[] arr = s.toLowerCase().split("");
		arr[0] = arr[0].toUpperCase();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1].equals(" ") && !arr[i].equals(" ")) {
				arr[i] = arr[i].toUpperCase();
			}
		}
		return String.join("", arr);
	}
}
