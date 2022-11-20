import java.util.*;

public class Main {
    
    static int N, M;
    static int[] A;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }
    
    static boolean determination(int length) {
        int cnt = 1, sum = 0;
        for(int i = 0; i < N; i++) {
            if(sum + A[i] > length) {
                cnt++;
                sum = A[i];
            } else {
                sum += A[i];
            }
        }
        return cnt <= M;
    }
    
    static void pro() {
        int max = 0;
        for(int i = 0; i < N; i++) max = Math.max(max, A[i]);
        int L = max, R = 1000000000, ans = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}