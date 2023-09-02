import java.util.*;
import java.io.*;

public class Main {
    
    private static long[] P;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        preprocess();
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            
            sb.append(P[N]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    private static void preprocess() {
        P = new long[101];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        for(int i = 6; i <= 100; i++) {
            P[i] = P[i - 1] + P[i - 5];
        }
    }
        
}