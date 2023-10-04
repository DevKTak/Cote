package fastcampus.인강.트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Node node = new Node('A');

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			buildTree(node, root, left, right);
		}

		preOrder(node);
		bw.write(System.lineSeparator());

		inOrder(node);
		bw.write(System.lineSeparator());

		postOrder(node);
		bw.flush();
		bw.close();
	}

	private static void buildTree(Node node, char root, char left, char right) {
		if (node.data == root) {
			if (left == '.') {
				node.left = null;
			} else {
				node.left = new Node(left);
			}

			if (right == '.') {
				node.right = null;
			} else {
				node.right = new Node(right);
			}
		} else {
			if (node.left != null) {
				buildTree(node.left, root, left, right);
			}
			if (node.right != null)
				buildTree(node.right, root, left, right);
		}
	}

	private static void preOrder(Node node) throws IOException {
		// 종료 조건
		if (node == null)
			return;
		bw.write(node.data);

		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) throws IOException {
		//종료 조건
		if (node == null)
			return;

		inOrder(node.left);
		bw.write(node.data);

		inOrder(node.right);
	}

	private static void postOrder(Node node) throws IOException {
		// 종료 조건
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		bw.write(node.data);
	}
}
