package goorm.No4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스도쿠 보드
public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            SudokuBoard sudokuBoard = new SudokuBoard();
            int rowNum =  sudokuBoard.getRowNum(N);
            int colNum =  sudokuBoard.getColNum(N);
            int groupNum = sudokuBoard.getGroup(rowNum, colNum);

            System.out.println("Case #" + i + ":");
            System.out.println(rowNum + " " + colNum + " " + groupNum);
        }
    }
}

class SudokuBoard {

    public int getRowNum(int N) {
        return (N - 1) / 9 + 1;
    }

    public int getColNum(int N) {
        return (N -1) % 9 + 1;
    }

    public int getGroup(int row, int col) {
        int _147 = ((row - 1) / 3) * 3 + 1;
        int _012 = (col - 1) / 3;

        return _147 + _012;
    }
}
