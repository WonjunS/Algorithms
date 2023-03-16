import java.util.*;

class Solution {
    
    static int N, M, start_x, start_y, lever_x, lever_y, exit_x, exit_y;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        dist = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i].charAt(j) == 'S') {
                    start_x = i;
                    start_y = j;
                }
                if(maps[i].charAt(j) == 'L') {
                    lever_x = i;
                    lever_y = j;
                }
                if(maps[i].charAt(j) == 'E') {
                    exit_x = i;
                    exit_y = j;
                }
            }
        }
        
        // (1)
        int answer = -1, f = 0, s = 0;
        f = bfs(start_x, start_y, lever_x, lever_y, maps);
        s = bfs(lever_x, lever_y, exit_x, exit_y, maps);
        
        if(f > 0 && s > 0)
            answer = f + s;
        
        return answer;
    }
    
    static int bfs(int a, int b, int c, int d, String[] maps) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        q.add(b);
        dist[a][b] = 0;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(maps[nx].charAt(ny) == 'X') continue;
                if(dist[nx][ny] != -1) continue;
                
                q.add(nx);
                q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        
        return dist[c][d];
    }
}