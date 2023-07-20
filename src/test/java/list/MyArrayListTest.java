package list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListTest {

//    @Test
//    public void add() {
//        IListt<Integer> given = new MyArrayList<>();
//
//        for (int i = 0; i < 50; i++) {
//            System.out.println(i);
//            given.add(i);
//
//            assertThat(given.get(i)).isEqualTo(i + 1);
//        }
//    }
//
//    @Test
//    public void clear() {
//        IListt<Integer> given = new MyArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//            given.add(i);
//        }
//
//        assertThat(given.size()).isEquals(100);
//        assertThat(given.isEmpty());
//    }
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add(null);
        boolean contains = list.contains(null);
        System.out.println(contains);
    }
}
