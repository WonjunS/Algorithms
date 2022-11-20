import java.util.*;

public class Main {
    
    static int M, N, H, ans;
    static int[][][] dist, a;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, 
                            {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        
        dist = new int[H][N][M];
        a = new int[H][N][M];
        
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    int x = sc.nextInt();
                    a[i][j][k] = x;
                }
            }
        }
    }
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    dist[i][j][k] = -1;
                    if(a[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                        q.add(i);
                        q.add(j);
                        q.add(k);
                    }
                }
            }
        }
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int z = q.poll();
            
            for(int i = 0; i < 6; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int nz = z + dir[i][2];
                if(nx < 0 || ny < 0 || nz < 0 || nx >= H || ny >= N || nz >= M) continue;
                if(dist[nx][ny][nz] != -1) continue;
                if(a[nx][ny][nz] == -1) continue;
                dist[nx][ny][nz] = dist[x][y][z] + 1;
                q.add(nx);
                q.add(ny);
                q.add(nz);
            }
        }
    }
    
    static void pro() {
        bfs();
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(a[i][j][k] == -1) continue;
                    if(dist[i][j][k] == -1) {
                        System.out.println("-1");
                        return;
                    }
                    ans = Math.max(ans, dist[i][j][k]);
                }
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}