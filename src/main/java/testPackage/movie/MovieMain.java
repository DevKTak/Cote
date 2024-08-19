// package testPackage.movie;
//
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.NoSuchElementException;
// import java.util.Optional;
//
// public class MovieMain {
//
// 	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 	public static void main(String[] args) throws IOException {
// 		List<Movie> movies = new ArrayList<>();
// 		int movieCount = 5;
//
// 		/**
// 		 *	1번 문제
// 		 *	영화 입력 및 오름차순 출력
// 		 */
// 		inputMovies(movies, movieCount);
// 		printMovies(movies);
//
// 		/**
// 		 * 	2번 문제
// 		 *	영화 제목 입력 시 해당 영화 검색(이진탐색)하여 출력
// 		 */
// 		System.out.print("\n영화제목: ");
// 		String searchTitle = br.readLine();
//
// 		Movie movie = binarySearchMovie(searchTitle, movies).orElseThrow(
// 			() -> new NoSuchElementException("해당 영화는 존재하지 않습니다."));
//
// 		printMovieByTitle(movie);
// 	}
//
// 	private static void printMovieByTitle(Movie movie) {
// 		System.out.println("\n영화제목 | 주인공 | 제작사 | 가격 | 등급");
// 		System.out.println(
// 			movie.getTitle() + " " + movie.getActor() + " " + movie.getCompany() + " " + movie.getPrice() + " "
// 				+ movie.getGrade());
// 	}
//
// 	private static void printMovies(List<Movie> movies) {
// 		Collections.sort(movies);
// 		StringBuilder sb = new StringBuilder();
//
// 		for (Movie movie : movies) {
// 			sb.append(System.lineSeparator()).append("제목: ").append(movie.getTitle());
// 			sb.append(System.lineSeparator()).append("주인공: ").append(movie.getActor());
// 			sb.append(System.lineSeparator()).append("제작사: ").append(movie.getCompany());
// 			sb.append(System.lineSeparator()).append("가격: ").append(movie.getPrice());
// 			sb.append(System.lineSeparator()).append("등급: ").append(movie.getGrade());
// 		}
// 		System.out.println(sb);
// 	}
//
// 	private static void inputMovies(List<Movie> movies, int movieCount) throws IOException {
// 		while (movieCount-- > 0) {
// 			movies.add(Movie.builder()
// 				.title(br.readLine())
// 				.actor(br.readLine())
// 				.company(br.readLine())
// 				.price(Integer.parseInt(br.readLine()))
// 				.grade(Integer.parseInt(br.readLine()))
// 				.build());
// 		}
// 	}
//
// 	private static Optional<Movie> binarySearchMovie(String searchTitle, List<Movie> movies) {
// 		int left = 0;
// 		int right = movies.size() - 1;
// 		int mid;
//
// 		while (left <= right) {
// 			mid = (left + right) / 2;
//
// 			if (searchTitle.compareTo(movies.get(mid).getTitle()) < 0) {
// 				right = mid - 1;
// 			} else if (searchTitle.compareTo(movies.get(mid).getTitle()) > 0) {
// 				left = mid + 1;
// 			} else {
// 				return Optional.ofNullable(movies.get(mid));
// 			}
// 		}
// 		return Optional.empty();
// 	}
// }
//
// /*
// [TestCase]
//
// 범죄도시3
// 마동석
// CJ시네마
// 18000
// 15
// 가가가
// 가동석
// 가시네마
// 11111
// 11
// 라라라
// 라동석
// 라시네마
// 44444
// 44
// 나나나
// 나동석
// 나시네마
// 22222
// 22
// 다다다
// 다동석
// 다시네마
// 33333
// 33
//  */
