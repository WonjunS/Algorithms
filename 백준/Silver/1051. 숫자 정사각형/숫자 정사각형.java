import java.util.*;

public class Main {
    
    static int N, M, max_len, ans;
    static int[][] A;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                A[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        
        max_len = Math.min(N, M);
    }
    
    static void pro() {
        for(int len = 1; len <= max_len; len++) {
            for(int i = 0; i <= N - len; i++) {
                for(int j = 0; j <= M - len; j++) {
                    search(i, j, len);
                }
            }
        }
        System.out.println(ans);
    }
    
    static void search(int x, int y, int len) {
        int nx = x + len - 1;
        int ny = y + len - 1;
        
        int[] n = new int[4];
        n[0] = A[x][y];
        n[1] = A[x][ny];
        n[2] = A[nx][y];
        n[3] = A[nx][ny];
        
        Arrays.sort(n);
        if(n[0] != n[3]) return;
        
        ans = Math.max(ans, len * len);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}