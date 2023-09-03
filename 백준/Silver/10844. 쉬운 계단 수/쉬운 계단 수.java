import java.util.*;
import java.io.*;

public class Main {
    
    private static long[][] DP;
    private static final long MOD = 1_000_000_000L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        preprocess();

        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer = (answer + DP[N][i]) % MOD;
            
        }
        
        System.out.println(answer % MOD);
    }
    
    private static void preprocess() {
        DP = new long[101][10];
        DP[1][0] = 0;
        DP[1][1] = 1;
        DP[1][2] = 1;
        DP[1][3] = 1;
        DP[1][4] = 1;
        DP[1][5] = 1;
        DP[1][6] = 1;
        DP[1][7] = 1;
        DP[1][8] = 1;
        DP[1][9] = 1;
        
        for(int i = 2; i <= 100; i++) {
            DP[i][0] = DP[i - 1][1] % MOD;
            DP[i][9] = DP[i - 1][8] % MOD;
            for(int j = 1; j <= 8; j++) {
                DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % MOD;
            }
        }
    }
    
}