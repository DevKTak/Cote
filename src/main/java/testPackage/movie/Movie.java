package testPackage.movie;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Movie implements Comparable<Movie> {

	private String title; // 제목
	private String actor; // 주인공
	private String company; // 제작사
	private int price; // 가격
	private int grade; // 등급

	@Override
	public int compareTo(Movie movie) {
		return this.title.compareTo(movie.title); // 제목별 오름차순
	}
}
