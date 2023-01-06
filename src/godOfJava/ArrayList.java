package godOfJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList {

    public static void main(String[] args) {
        List<String> list = new java.util.ArrayList<>();
        list.add("박경탁1");
        list.add("박경탁2");
        list.add("박경탁3");
        list.add("박경탁4");

        // indexOf()
        int index = list.indexOf("박경탁4");
        System.out.println(index);

        // toArray()
        String[] arr = list.toArray(new String[0]);
        System.err.println(Arrays.toString(arr));

        // removeAll
        List<String> list2 = new java.util.ArrayList<>(list);
        list2.add("박경탁5");
        System.out.println("list: " + list);
        System.out.println("list2: " + list2);

        list2.removeAll(list);

        System.out.println("list: " + list);
        System.out.println("list2: " + list2);

        // Thread safe ArrayList
        List<String> synchronizedList = Collections.synchronizedList(new java.util.ArrayList<>());



    }
}
