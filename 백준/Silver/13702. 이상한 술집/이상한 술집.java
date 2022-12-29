import java.util.*;

public class Main {
    
    static int N, K;
    static long[] A;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        A = new long[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
    }
        
    static void pro() {
        Arrays.sort(A);
        
        long L = 1, R = (long) Math.pow(2, 32) - 1, ans = R;
        while(L <= R) {
            long mid = (L + R) / 2;
            
            if(determination(mid)) {
                L = mid + 1;
                ans = mid;
            } else {
                R = mid - 1;
            }
        }
        
        System.out.println(ans);
    }
    
    static boolean determination(long x) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            count += A[i] / x;
        }
        
        return count >= K;
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}