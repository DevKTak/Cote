package fastcampus.인강.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_09934_완전이진트리_re {

	private static class Node {

		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		int nodeCnt = (int)(Math.pow(2, K) - 1);
		st = new StringTokenizer(br.readLine());
		List<Integer> inOrderList = new ArrayList<>();

		while (nodeCnt-- > 0) {
			inOrderList.add(Integer.parseInt(st.nextToken()));
		}

		Node rootNode = buildBinaryTree(inOrderList, 0, inOrderList.size() - 1);
		printTree(rootNode);

	}

	private static Node buildBinaryTree(List<Integer> inOrderList, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex) {
			return null;
		}
		int middleIndex = (leftIndex + rightIndex) / 2;
		Node rootNode = new Node(inOrderList.get(middleIndex));

		if (leftIndex == rightIndex) {
			return rootNode;
		}

		rootNode.left = buildBinaryTree(inOrderList, leftIndex, middleIndex - 1);
		rootNode.right = buildBinaryTree(inOrderList, middleIndex + 1, rightIndex);

		return rootNode;
	}

	private static void printTree(Node rootNode) {
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(rootNode);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();

			for (int i = 0; i < queueSize; i++) {
				Node curNode = queue.poll();
				sb.append(curNode.data + " ");

				if (curNode.left != null) {
					queue.offer(curNode.left);
				}
				if (curNode.right != null) {
					queue.offer(curNode.right);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
