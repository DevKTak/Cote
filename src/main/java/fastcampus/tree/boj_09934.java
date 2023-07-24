package fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_09934 {

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

        int K = Integer.parseInt(br.readLine()); // 트리 깊이
        int nodeCnt = (int) (Math.pow(2, K) - 1); // 깊이가 K인 완전 이진 트리의 노드 수(2의 K제곱 - 1)

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nodeCnt; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        buildTree(list, 0, list.size());
        printTree();

    }

    private static Node buildTree(List<Integer> inOrderList, int leftIndex, int rightIndex) {
        // 종료 조건
//        if () {
//            return null;
//        }

        int middleIndex = (leftIndex + rightIndex) / 2;
        Node node = new Node(inOrderList.get(middleIndex));
        if (leftIndex == rightIndex) {
            return node;
        }

        node.left = buildTree(inOrderList, 0, middleIndex - 1);
        node.right = buildTree(inOrderList, middleIndex + 1, inOrderList.size() - 1);

        return node;
    }

    private static void printTree() {

    }
}
