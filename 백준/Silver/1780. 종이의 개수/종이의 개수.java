import java.util.*;
import java.io.*;

public class Main {
    
    private static int[][] board;
    private static int a, b, c, N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                board[i][j] = x;
            }
        }
        
        partition(0, 0, N);
        
        StringBuilder sb = new StringBuilder();
        sb.append(a)
            .append('\n')
            .append(b)
            .append('\n')
            .append(c);
        
        System.out.println(sb.toString());
    }
    
    private static void partition(int row, int col, int len) {
        boolean result = isUnified(row, col, len);
        if(result == true) {
            int x = board[row][col];
            if(x == -1) {
                a++;
            } else if(x == 0) {
                b++;
            } else {
                c++;
            }
            return ;
        }
        
        int newLen = len / 3;
        int len2 = newLen * 2;
        partition(row, col, newLen);
        partition(row, col + newLen, newLen);
        partition(row, col + len2, newLen);
        partition(row + newLen, col, newLen);
        partition(row + newLen, col + newLen, newLen);
        partition(row + newLen, col + len2, newLen);
        partition(row + len2, col, newLen);
        partition(row + len2, col + newLen, newLen);
        partition(row + len2, col + len2, newLen);
    }
    
    private static boolean isUnified(int row, int col, int len) {
        int x = board[row][col];
        boolean result = true;
        for(int i = row; i < row + len; i++) {
            for(int j = col; j < col + len; j++) {
                if(board[i][j] != x) {
                    result = false;
                    break;
                }
            }
            if(!result) {
                break;
            }
        }
        
        return result;
    }
    
}