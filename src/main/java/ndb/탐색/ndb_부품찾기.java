package ndb.탐색;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ndb_부품찾기 {

    private static int n = 5;
    private static int[] nArr = {8, 3, 7, 9, 2};
    private static int m = 3;
    private static int[] mArr = {5, 7, 9};

    public static void main(String[] args) {
        solutionSet();

        System.out.println(System.lineSeparator());

        solutionBy계수정렬();
    }

    private static void solutionSet() {
        Set<Integer> set = new HashSet<>();

        Arrays.stream(nArr).forEach(set::add);

        for (int v : mArr) {
            if (set.contains(v)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static void solutionBy계수정렬() {
        int[] cntArr = new int[10000001];

        for (int n : nArr) {
            cntArr[n] += 1;
        }

        for (int m : mArr) {
            if (cntArr[m] == 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
