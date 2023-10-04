import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                A[i][j] = x;
            }
        }
        
        int[][][] DP = new int[N][M][3];
        for(int j = 0; j < M; j++) {
            DP[0][j][0] = A[0][j];
            DP[0][j][1] = A[0][j];
            DP[0][j][2] = A[0][j];
        }
        
        for(int i = 1; i < N; i++) {
            DP[i][0][0] = Integer.MAX_VALUE;
            DP[i][M - 1][2] = Integer.MAX_VALUE;
            for(int j = 0; j < M; j++) {
                if(j == 0) {
                    DP[i][j][1] = Math.min(DP[i - 1][j][0], DP[i - 1][j][2]) + A[i][j];
                    DP[i][j][2] = Math.min(DP[i - 1][j + 1][0], DP[i - 1][j + 1][1]) + A[i][j];
                } else if(j == M - 1) {
                    DP[i][j][0] = Math.min(DP[i - 1][j - 1][1], DP[i - 1][j - 1][2]) + A[i][j];
                    DP[i][j][1] = Math.min(DP[i - 1][j][0], DP[i - 1][j][2]) + A[i][j];
                } else {
                    DP[i][j][0] = Math.min(DP[i - 1][j - 1][1], DP[i - 1][j - 1][2]) + A[i][j];
                    DP[i][j][1] = Math.min(DP[i - 1][j][0], DP[i - 1][j][2]) + A[i][j];
                    DP[i][j][2] = Math.min(DP[i - 1][j + 1][0], DP[i - 1][j + 1][1]) + A[i][j];
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < 3; j++) {
                answer = Math.min(DP[N - 1][i][j], answer);
            }
        }
        
        System.out.println(answer);
    }
    
}