import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, K;
    private static int[] W;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        W = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(W);
        
        int L = 0, R = N - 1;
        int count = 0;
        while(L < R) {
            int sum = W[L] + W[R];
            if(sum > K) {
                R--;
            } else {
                R--;
                L++;
                count++;
            } 
        }
        
        System.out.println(count);
    }
    
}