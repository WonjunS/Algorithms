import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, white, blue;
    static int[][] board;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        partition(0, 0, N);
        
        sb.append(white).append('\n');
        sb.append(blue).append('\n');
        
        System.out.println(sb);
    }
    
    static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if(board[row][col] == 0) white++;
            else blue++;
            
            return;
        }
        
        int newSize = size / 2;
        
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }
    
    static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];
        
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(color != board[i][j]) return false;
            }
        }
        
        return true;
    }
}