package boj.etc;

import java.util.Scanner;

public class bj_17478 {

	public static final Scanner scanner = new Scanner(System.in);
	public static int N;

	public static void main(String[] args) {
		N = scanner.nextInt();

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

		recursion(0);
	}

	private static void recursion(int num) {
		String underBar = "";
		String[] strArr = new String[5];
		strArr[0] = "\"재귀함수가 뭔가요?\"";
		strArr[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		strArr[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		strArr[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		strArr[4] = "라고 답변하였지.";

		for (int i = 0; i < num; i++) {
			underBar += "____";
		}

		if (num == N) {
			System.out.println(underBar + strArr[0]);
			System.out.println(underBar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		} else {
			for (int i = 0; i < 4; i++) {
				System.out.println(underBar + strArr[i]);
			}

			recursion(num + 1);
		}
		System.out.println(underBar + strArr[4]);
	}
}

//  어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.

//   "재귀함수가 뭔가요?"
//   "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//   마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//   그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."

//   ____"재귀함수가 뭔가요?"
//   ____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//   ____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//   ____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."

//   ________"재귀함수가 뭔가요?"
//   ________"재귀함수는 자기 자신을 호출하는 함수라네"

//   ________라고 답변하였지.
//   ____라고 답변하였지.
//   라고 답변하였지.
