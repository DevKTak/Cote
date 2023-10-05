package fastcampus.실강.해시.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 숫자짝꿍 {

	public static void main(String[] args) {
		숫자짝꿍 T = new 숫자짝꿍();
		System.out.println(T.solution("12321", "42531"));
		System.out.println(T.solution("5525", "1255"));
		System.out.println(T.solution("100", "2345"));
		System.out.println(T.solution("100", "123450")); // 10

		System.out.println(Integer.parseInt("01485000") == 0);
	}

	public String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();

		for (char x : X.toCharArray()) {
			xMap.put(x - 48, xMap.getOrDefault(x - 48, 0) + 1);
		}
		for (char y : Y.toCharArray()) {
			yMap.put(y - 48, yMap.getOrDefault(y - 48, 0) + 1);
		}
		for (int x : xMap.keySet()) {
			if (yMap.get(x) != null) {
				for (int i = 0; i < Math.min(xMap.get(x), yMap.get(x)); i++) {
					sb.append(x);
				}
			}
		}

		// StringBuilder 내림차순
		String result = sb.reverse().toString();

		if (sb.toString().equals("")) {
			result = "-1";
		} else if (sb.charAt(0) == '0') {
			result = "0";
		}
		return result;
	}

	// 다른 풀이 참고
/*	public String solution(String X, String Y) {
		StringBuilder answer = new StringBuilder();
		int[] x = {0,0,0,0,0,0,0,0,0,0};
		int[] y = {0,0,0,0,0,0,0,0,0,0};
		for(int i=0; i<X.length();i++){
			x[X.charAt(i)-48] += 1;
		}
		for(int i=0; i<Y.length();i++){
			y[Y.charAt(i)-48] += 1;
		}

		for(int i=9; i >= 0; i--){
			for(int j=0; j<Math.min(x[i],y[i]); j++){
				answer.append(i);
			}
		}
		if("".equals(answer.toString())){
			return "-1";
		}else if(answer.toString().charAt(0)==48){
			return "0";
		}else {
			return answer.toString();
		}
	}*/
}
