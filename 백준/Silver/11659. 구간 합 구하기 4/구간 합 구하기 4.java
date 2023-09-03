import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] sums;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        sums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int k = 1; k <= N; k++) {
            int x = Integer.parseInt(st.nextToken());
            sums[k] = sums[k - 1] + x;
        }
        
        for(int k = 1; k <= M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            int sum = sums[j] - sums[i - 1];
            
            sb.append(sum).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}