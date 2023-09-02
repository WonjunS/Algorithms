import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            A[i] = x;
        }
        
        if(n == 1) {
            System.out.println(A[0]);
            return;
        }
        
        if(n == 2) {
            int answer = Math.max(A[0], Math.max(A[1], A[0] + A[1]));
            System.out.println(answer);
            return;
        }
        
        int[][] DP = new int[n][2];
        DP[0][0] = A[0];
        DP[0][1] = 0;
        for(int i = 1; i < n; i++) {
            DP[i][0] = Math.max(DP[i - 1][0], 0) + A[i];
            DP[i][1] = DP[i - 1][0];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, DP[i][0]);
        }
        for(int i = 2; i < n; i++) {
            max = Math.max(max, DP[i][1]);
        }
        
        System.out.println(max);
    }
    
}