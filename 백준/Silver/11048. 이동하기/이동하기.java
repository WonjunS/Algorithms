import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] DP = new int[N][M];
        DP[0][0] = map[0][0];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) {
                    DP[i][j] = DP[i][j - 1] + map[i][j];
                }
                if(j == 0) {
                    DP[i][j] = DP[i - 1][j] + map[i][j];
                }
                if(i != 0 && j != 0) {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]) + map[i][j];
                }
            }
        }
        
        System.out.println(DP[N - 1][M - 1]);
    } 
    
}