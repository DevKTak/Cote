package godOfJava;

import java.util.function.Predicate;

public class FunctionalInterface implements Predicate<String> {

    public static void main(String[] args) {
        Predicate<String> predicateLength5 = a -> a.length() > 5;
        Predicate<String> predicateContains = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.contains("Tak");
            }
        };
        System.out.println("predicateLength5: " + predicateLength5.test("asdasda"));
        System.out.println("predicateContains: " + predicateContains.test("abc"));

        System.out.println("predicateLength5.and(predicateContains): " + predicateLength5.and(predicateContains).test("false가 나올꺼야"));
        System.out.println("predicateLength5.and(predicateContains): " + predicateLength5.and(predicateContains).test("true가 나올것이야 Tak"));

//        FunctionalInterface functionalInterface = new FunctionalInterface();
//        System.err.println(functionalInterface.test("a"));
//        System.err.println(functionalInterface.test("aaaaaaa"));
    }

    @Override
    public boolean test(String s) {
        return false;
    }

}
