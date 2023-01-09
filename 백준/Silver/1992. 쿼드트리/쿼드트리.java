import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }

    static void partition(int row, int col, int size) {
        if(isPossible(row, col, size)) {
            sb.append(board[row][col]);
            return;
        }
        int newSize = size / 2;
        
        sb.append('(');
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        sb.append(')');
    }

    static boolean isPossible(int row, int col, int size) {
        int num = board[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(num != board[i][j]) return false;
            }
        }

        return true;
    }
}