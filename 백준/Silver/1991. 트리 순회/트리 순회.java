import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	private static class Node {
		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
		}
	}

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Map<Character, Node> nodeMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char rootValue = st.nextToken().charAt(0);
			char leftValue = st.nextToken().charAt(0);
			char rightValue = st.nextToken().charAt(0);

			Node root = nodeMap.getOrDefault(rootValue, new Node(rootValue));
			root.left = leftValue == '.' ? null : nodeMap.getOrDefault(leftValue, new Node(leftValue));
			root.right = rightValue == '.' ? null : nodeMap.getOrDefault(rightValue, new Node(rightValue));

			nodeMap.put(rootValue, root);
			if (!nodeMap.containsKey(leftValue)) {
				nodeMap.put(leftValue, root.left);
			}
			if (!nodeMap.containsKey(rightValue)) {
				nodeMap.put(rightValue, root.right);
			}
		}

		Node rootNode = nodeMap.get('A');

		preOrder(rootNode);
		bw.write("\n");

		inOrder(rootNode);
		bw.write("\n");

		postOrder(rootNode);
		bw.write("\n");

		bw.flush();
		bw.close();
	}

	private static void preOrder(Node node) throws IOException {
		if (node == null) return;

		bw.write(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) throws IOException {
		if (node == null) return;

		inOrder(node.left);
		bw.write(node.data);
		inOrder(node.right);
	}

	private static void postOrder(Node node) throws IOException {
		if (node == null) return;

		postOrder(node.left);
		postOrder(node.right);
		bw.write(node.data);
	}
}

