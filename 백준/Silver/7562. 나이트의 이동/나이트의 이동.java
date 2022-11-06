import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static int T, N, start_x, start_y, end_x, end_y;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] dir = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, 
                          {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
    
    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(x);
        q.add(y);
        
        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for(int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            N = sc.nextInt();
            visit = new boolean[N][N];
            dist = new int[N][N];
            
            start_x = sc.nextInt();
            start_y = sc.nextInt();
            end_x = sc.nextInt();
            end_y = sc.nextInt();
            
            bfs(start_x, start_y);
            sb.append(dist[end_x][end_y]).append('\n');
        }
        System.out.println(sb);
    }
}