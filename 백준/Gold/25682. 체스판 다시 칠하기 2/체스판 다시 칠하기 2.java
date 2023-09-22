import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, M, K;
    private static char[][] board;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        System.out.println(Math.min(findMinimum('B'), findMinimum('W')));
        
    }
    
    private static int findMinimum(char color) {
        int min = Integer.MAX_VALUE;
        int value;
        int[][] sums = new int[N + 1][M + 1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if((i + j) % 2 == 0) {
                    value = (board[i][j] == color) ? 0 : 1;
                } else {
                    value = (board[i][j] == color) ? 1 : 0;
                }
                
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + value;
            }
        }
        
        for(int i = 1; i <= N - K + 1; i++) {
            for(int j = 1; j <= M - K + 1; j++) {
                min = Math.min(min, sums[i + K - 1][j + K - 1] - sums[i + K - 1][j - 1] 
                               - sums[i - 1][j + K - 1] + sums[i - 1][j - 1]);
            }
        }
        
        return min;
    }
    
}