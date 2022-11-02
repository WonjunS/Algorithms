import java.util.*;

public class Main {
    
    static int N, count;
    static int[] A;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        
        Arrays.sort(A, 1, N + 1);
    }
    
    static void pro() {
        count = 0;
        
        if(N > 2) {
            for(int i = 1; i <= N; i++)
                if(isGoodNumber(i)) count++;
        }
        
        System.out.println(count);
    }
    
    static boolean isGoodNumber(int idx) {
        int L = 1;
        int R = N;
        while(L < R) {
            if(L == idx) {
                L++;
                continue;
            }
            if(R == idx){
                R--;
                continue;
            }
            int sum = A[L] + A[R];
            if(sum == A[idx]) 
                return true;
            if(sum > A[idx]) {
                R--;
                continue;
            }
            if(sum < A[idx]) {
                L++;
                continue;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}