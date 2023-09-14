import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, M;
    private static int[][] A, S;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N + 1][N + 1];
        S = new int[N + 1][N + 1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());
                A[i][j] = x;
            }
        }
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                S[i][j] = A[i][j];
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                S[i][j] += S[i][j - 1];
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                S[i][j] += S[i - 1][j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int result = S[x2][y2] + S[x1 - 1][y1 - 1] - S[x1 - 1][y2] - S[x2][y1 - 1];
            
            sb.append(result).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}