package fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 완전 이진 트리
 */
public class boj_09934_완전이진트리 {

    private static class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine()); // 트리 깊이
        int nodeCnt = (int) (Math.pow(2, K) - 1); // 깊이가 K인 완전 이진 트리의 노드 수(2의 K제곱 - 1)

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nodeCnt; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Node rootNode = buildTree(list, 0, list.size() - 1);
        printTree(rootNode);
    }

    private static Node buildTree(List<Integer> inOrderList, int leftIndex, int rightIndex) {
        // 종료 조건
        if (leftIndex > rightIndex) {
            return null;
        }

        int middleIndex = (leftIndex + rightIndex) / 2;
        Node rootNode = new Node(inOrderList.get(middleIndex));
        if (leftIndex == rightIndex) {
            return rootNode;
        }

        rootNode.left = buildTree(inOrderList, leftIndex, middleIndex - 1);
        rootNode.right = buildTree(inOrderList, middleIndex + 1, rightIndex);

        return rootNode;
    }

    private static void printTree(Node rootNode) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(rootNode);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                sb.append(node.data + " ");

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
