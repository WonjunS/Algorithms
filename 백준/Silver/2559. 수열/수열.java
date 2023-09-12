import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sums = new int[N + 1];
        for(int i = 1; i <= K; i++) {
            sums[i] += sums[i - 1] + A[i];
        }
        
        for(int i = K; i <= N; i++) {
            sums[i] = sums[i - 1] - A[i - K] + A[i];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = K; i <= N; i++) {
            max = Math.max(sums[i], max);
        }
        
        System.out.println(max);
    }
    
}