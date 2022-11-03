import java.util.*;

class Solution {
    
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        dist = new int[n][m];
        bfs(maps, dist, n, m);
        
        if(dist[n - 1][m - 1] == 0) return -1;
        answer = dist[n - 1][m - 1];
        
        return answer;
    }
    
    static void bfs(int[][] maps, int[][] dist, int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        q.add(0);
        q.add(0);
        visit[0][0] = true;
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            int a = q.poll();
            int b = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = a + dir[i][0];
                int ny = b + dir[i][1];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visit[nx][ny]) continue;
                if(maps[nx][ny] == 0) continue;
                
                dist[nx][ny] = dist[a][b] + 1;
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }
    }
}