package fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_01991_트리순회 {

	private static class Node {

		private char data;
		private Node left;
		private Node right;

		public Node(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				// Node RootNode = st.nextToken()
			}
		}
	}

	private static void inOrder() {

	}
}
