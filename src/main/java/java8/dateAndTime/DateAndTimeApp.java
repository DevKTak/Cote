package java8.dateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateAndTimeApp {

    public static void main(String[] args) {

        //== LocalDateTime 사용 ==//
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("연도: " + localDateTime.getYear());
        System.out.println("월: " + localDateTime.getMonth());
        System.out.println("월: " + localDateTime.getMonth().getValue());
        System.out.println("일: " + localDateTime.getDayOfMonth());
        System.out.println("요일: " + localDateTime.getDayOfWeek());
        System.out.println("365일 중 몇일: " + localDateTime.getDayOfYear() + System.lineSeparator());

        System.out.println("시: " + localDateTime.getHour());
        System.out.println("분: " + localDateTime.getMinute());
        System.out.println("초: " + localDateTime.getSecond() + System.lineSeparator());

        LocalDateTime birthDay = LocalDateTime.of(1992, Month.NOVEMBER, 24, 0, 0, 0);
        System.out.println("지정일: " + birthDay + System.lineSeparator());

        //== Period 두 날짜 사이의 간격 ==//
        LocalDate startDate = LocalDate.of(2021, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 3, 1);
        System.out.println("startDate + 50일: " + startDate.plus(Period.ofDays(50)));
        System.out.println("startDate + 50일: " + startDate.plus(50, ChronoUnit.DAYS));

        Period between = Period.between(startDate, endDate);
        System.out.println("년 간격: " + between.getYears());
        System.out.println("월 간격: " + between.getMonths());
        System.out.println("일 간격: " + between.getDays());
        System.out.println("일 간격: " + between.get(ChronoUnit.DAYS) + System.lineSeparator());

        //== Duration 두 시간 사이의 간격 ==//
        LocalTime startTime = LocalTime.of(15, 30);
        LocalTime endTime = LocalTime.of(16, 40);
        System.out.println("startTime + 50분: " + startTime.plus(50, ChronoUnit.MINUTES));

        Duration betweenTime = Duration.between(startTime, endTime);
        System.out.println("초 간격: " + betweenTime.getSeconds());
        System.out.println("간격이 음수인지: " + betweenTime.isNegative());
        System.out.println("간격이 0인지: " + betweenTime.isZero() + System.lineSeparator());

        //== 날짜 포매팅 ==//
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        System.out.println(now.format(yyyyMMddHHmmss));

        //== String을 파싱하여 LocalDateTime으로 변한 ==//
        String string = "1992년 11월 24일 00시 00분 00초";
        LocalDateTime parse = LocalDateTime.parse(string, DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        System.out.println(parse);
    }
}
