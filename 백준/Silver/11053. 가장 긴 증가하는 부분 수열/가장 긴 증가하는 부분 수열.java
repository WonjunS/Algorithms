import java.util.*;

public class Main {
    
    static int N, ans;
    static int[] A, Dy;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        A = new int[N];
        Dy = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }
    
    static void pro() {
        Dy[0] = 1;
        for(int i = 1; i < N; i++) {
            Dy[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(A[i] > A[j]) {
                    Dy[i] = Math.max(Dy[i], Dy[j] + 1);
                }
            }
        }
        
        for(int n : Dy) {
            ans = Math.max(ans, n);
        }
        
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}