package java8.stream;

import java8.OnlineClass;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApp {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("\nspring 으로 시작하는 수업");
        springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        System.out.println("\nclose 되지 않은 수업");
        springClasses.stream()
//                .filter(onlineClass -> !onlineClass.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed)) // 위와 같음
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        System.out.println("\n수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
//                .map(onlineClass -> onlineClass.getTitle())
                .map(OnlineClass::getTitle)
//                .forEach(s -> System.out.println(s));
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "the Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("\n두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
//                .flatMap(list -> list.stream())
                .flatMap(Collection::stream)
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        System.out.println("\n10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("\n스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

        System.out.println("\n자바 수업 중에 The Java가 포함된 수업의 id의 합");
        int sum = javaClasses.stream()
                .filter(oc -> oc.getTitle().contains("The Java"))
                .mapToInt(OnlineClass::getId)
                .sum();
        System.out.println(sum);

        System.out.println("\n Stream 배열 => int[] 반환");
        int[] arr = {1, 2, 3};

        int[] result1 = Arrays.stream(arr)
                .map(v -> v + 10)
                .toArray();
        System.out.println(Arrays.toString(result1));

        System.out.println("\n Stream 리스트 => String[] 반환");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        String[] result2 = list.stream()
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(result2));

        /**
         * flatMap 공부
         */
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5);
        List<Integer> c = Arrays.asList(6, 7, 8);

        List<List<Integer>> listOfListOfInts = Arrays.asList(a, b, c);

        System.out.println("Before flattening: " + listOfListOfInts);

        Stream<List<Integer>> stream = listOfListOfInts.stream();
        List<Integer> collect = stream.flatMap(abc -> abc.stream()).collect(Collectors.toList());
        System.out.println(collect);


        System.out.println("Student 객체들이 저장된 student 리스트에서 모든 학생들의 모든 과목의 평균");

        List<Student> students = Arrays.asList(
                new Student(80, 90, 75),
                new Student(70, 100, 75),
                new Student(85, 90, 85),
                new Student(80, 100, 90)
        );

        students.stream()
                .flatMapToInt(student -> IntStream.of(student.getKor(), student.getEng(), student.getMath()))
                .average()
                .ifPresent(avg -> System.out.println(Math.round(avg * 10) /10.0));

        System.out.println("Outer로부터 String foo를 꺼내기 위해서는 NullPointerException을 막기 위해 아래와 같은 여러 번의 null 검사가 불가피하다. 하지만 이러한 부분 역시 flatMap을 사용하면 다음과 같이 코드를 가독성있게 작성할 수 있다.");

        // flatMap 적용 전
        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }

        // flatMap 적용 후
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);
    }

    static class Outer {
        Nested nested = new Nested();
    }

    static class Nested {
        Inner inner = new Inner();
    }

    static class Inner {
        String foo = "박경탁";
    }

    static class Student {

        private int kor;
        private int eng;
        private int math;

        public Student(int kor, int eng, int math) {
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMath() {
            return math;
        }
    }
}
