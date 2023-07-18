package ndb.정렬;

import java.util.Arrays;
import java.util.Comparator;

public class ndb_성적이낮은순서로학생출력하기 {

    public static void main(String[] args) {
        NameAndGrade hong = new NameAndGrade("홍길동", 95);
        NameAndGrade lee = new NameAndGrade("이순신", 77);
        NameAndGrade park = new NameAndGrade("박경탁", 100);
        NameAndGrade park2 = new NameAndGrade("박경탁2", 100);
        NameAndGrade[] arr = {hong, lee, park, park2};

//        Arrays.sort(arr, (nameAndGrade1, nameAndGrade2) ->
//           nameAndGrade1.getGrade() - nameAndGrade2.getGrade()
//        );
//        Arrays.sort(arr, Comparator.comparingInt(NameAndGrade::getGrade));
//        for (NameAndGrade nameAndGrade : arr) {
//            System.out.println(nameAndGrade.getName());
//        }

        /** Comparator 구현 (성적 내림차순 + 이름 내림차순) */
        Arrays.stream(arr)
                .sorted(Comparator.comparing(NameAndGrade::getGrade).reversed()
                .thenComparing(Comparator.comparing(NameAndGrade::getName).reversed()))
                .forEach(nameAndGrade -> System.out.println(nameAndGrade.getName() + " " + nameAndGrade.getGrade()));

        System.out.println();

        /** Comparable 구현 */
        Arrays.sort(arr);

        for (NameAndGrade nameAndGrade : arr) {
            System.out.println(nameAndGrade.getName());
        }
    }

    private static class NameAndGrade implements Comparable<NameAndGrade> {

        private String name;
        private int grade;

        NameAndGrade(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }

        @Override
        public int compareTo(NameAndGrade nameAndGrade) {
            if (this.grade < nameAndGrade.getGrade()) {
                return -1;
            }

            return 1;
        }
    }
}


