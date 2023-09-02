import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] DP;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        preprocess();
        
        System.out.println(DP[N]);
    }
    
    private static void preprocess() {
        // 1
        // 11, 00
        // 111, 001, 100
        // 1111 0011 1001 1100 0000
        
        DP = new int[1000001];
        DP[1] = 1;
        DP[2] = 2;
        for(int i = 3; i <= 1000000; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 15746;
        }
    }
    
}