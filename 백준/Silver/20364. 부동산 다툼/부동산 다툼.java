import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static int N, Q;
    static boolean[] occupied;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        Q = sc.nextInt();
        
        occupied = new boolean[N + 1];
        
        for(int i = 1; i <= Q; i++) {
            int x = sc.nextInt();
            
            solve(x);
        }
        
        System.out.println(sb);
    }
    
    static void solve(int k) {
        int x = k;
        int n = -1;
        while(x > 1) {
            if(occupied[x]) n = x;
            x /= 2;
        }
        if(n == -1) {
            occupied[k] = true;
            sb.append('0').append('\n');
        } else {
            sb.append(n).append('\n');
        }
    }
}