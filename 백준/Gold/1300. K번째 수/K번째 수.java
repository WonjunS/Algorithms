import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        int min = 1;
        int max = k;
        while(min < max) {
            int mid = (min + max) / 2;
            
            int cnt = 0;
            for(int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            
            if(cnt >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
    
}