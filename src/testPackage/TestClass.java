package testPackage;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        List<Integer> collect = new Random()
                .ints(45, 50 )
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(collect);
    }

}
