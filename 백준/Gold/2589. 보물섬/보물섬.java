import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M, ans;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'W') continue;
                visit = new boolean[N][M];
                dist = new int[N][M];
                ans = Math.max(ans, bfs(i, j));
            }
        }
        
        System.out.println(ans);
    }
    
    static int bfs(int x, int y) {
        int max = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visit[x][y] = true;
        dist[x][y] = 0;
        
        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 'W') continue;
                if(visit[nx][ny]) continue;
                dist[nx][ny] = dist[x][y] + 1;
                max = Math.max(max, dist[nx][ny]);
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }
        
        return max;
    }
}