package ndb.정렬;

import java.util.Arrays;
import java.util.Collections;

public class ndb_위에서아래로 {

    public static void main(String[] args) {
        int N = 3;
        Integer[] arr = {15, 27, 12};

//        Arrays.sort(arr, ((o1, o2) -> o2 - o1));
        Arrays.sort(arr, Collections.reverseOrder());
        
        System.out.println(Arrays.toString(arr));
    }
}
