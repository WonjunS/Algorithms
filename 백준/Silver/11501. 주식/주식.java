import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] A;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());  
            A = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                A[i] = x;
            }
            
            long total = 0;
            int max = 1;
            int k = N - 1;
            while(true) {
                if(k < 0) {
                    break;
                }

                if(A[k] > max) {
                    max = A[k];
                } else {
                    total += max - A[k];
                }
                
                k--;
            }
            
            sb.append(total).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}