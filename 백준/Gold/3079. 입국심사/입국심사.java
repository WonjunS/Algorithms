import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M, max_value;
    static int[] A;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        
        A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            max_value = Math.max(max_value, A[i]);
        }
    }
    
    static void pro() {
        long L = 1, R = max_value * 1000000000L, ans = 0L;
        
        while(L <= R) {
            long mid = (L + R) / 2;
            if(determination(mid)) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
    
    static boolean determination(long time) {
        long count = 0;
        for(int i = 0; i < N; i++) {
            count += (time / (long) A[i]);
            if(count >= M) break;
        }
        
        return count >= M;
    }
    
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}