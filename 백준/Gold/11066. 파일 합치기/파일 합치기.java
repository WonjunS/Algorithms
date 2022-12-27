import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static int T, K;
    static int[] arr;
    static int[][] sum, Dy;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            K = sc.nextInt();
            arr = new int[K + 1];
            sum = new int[K + 1][K + 1];
            Dy = new int[K + 1][K + 1];
            for(int j = 1; j <= K; j++) {
                arr[j] = sc.nextInt();
            }
            solve();
        }
        
        System.out.println(sb);
    }
    
    static void preprocess() {
        for(int i = 1; i <= K; i++) {
            for(int j = i; j <= K; j++) {
                sum[i][j] = sum[i][j - 1] + arr[j];
            }
        }
    }
    
    static void solve() {
        preprocess();
        
        for(int len = 2; len <= K; len++) {
            for(int i = 1; i <= K - len + 1; i++) {
                int j = i + len - 1;
                Dy[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k + 1][j] + sum[i][j]);
                }
            }
        }
        
        sb.append(Dy[1][K]).append('\n');
    }
}