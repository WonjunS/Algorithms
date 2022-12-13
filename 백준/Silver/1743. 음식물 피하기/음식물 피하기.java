import java.util.*;

public class Main {
    
    static int N, M, K, ans;
    static int[][] R;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        R = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        
        for(int i = 1; i <= K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            R[x][y] = 1;
        }
    }
    
    static void pro() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(R[i][j] == 0) continue;
                if(visit[i][j]) continue;
                bfs(i, j);
            }
        }
        
        System.out.println(ans);
    }
    
    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        int dist = 1;
        q.add(x);
        q.add(y);
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                
                if(nx < 0 || ny < 0 || nx > N || ny > M) continue;
                if(R[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;
                
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
                dist++;
            }
        }
        ans = Math.max(ans, dist);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}