import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {

	public static String valid(String answerStr) {
		int cnt = 0;
		for (int i = 0; i < answerStr.length(); i++) {
			if (answerStr.charAt(i) == '(') {
				cnt++;
			} else {
				cnt--;
			}
			if (cnt < 0) {
				return "NO";
			}
		}
		if (cnt == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String answer = st.nextToken();
			System.out.println(valid(answer));
		}
	}
}
