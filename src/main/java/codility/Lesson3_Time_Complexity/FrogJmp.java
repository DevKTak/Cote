package codility.Lesson3_Time_Complexity;

public class FrogJmp {

    public static void main(String[] args) {
        System.out.println(solution(5, 5, 2));
        System.out.println(solution(10, 85, 30));
    }

    private static int solution(int X, int Y, int D) {
        int mok = (Y - X) / D;

        return (Y - X) % D == 0 ? mok : mok + 1;
    }
}
