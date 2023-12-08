import java.util.*;

class Solution {
    
    private static int N, M, answer;
    private static boolean[][] visit;
    private static int[] A;
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        
        A = new int[M];
        visit = new boolean[N][M];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[j][i] && land[j][i] == 1) {
                    bfs(j, i, land);
                }
            }
        }
        
        for(int i = 0; i < M; i++) {
            answer = Math.max(answer, A[i]);
        }
        
        return answer;
    }
    
    private static void bfs(int x, int y, int[][] land) {
        int count = 1;
        
        boolean[] used = new boolean[M];
        
        Queue<Integer> q = new LinkedList<>();
        visit[x][y] = true;
        used[y] = true;
        q.add(x);
        q.add(y);
        
        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = x + dirs[k][0];
                int ny = y + dirs[k][1];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(land[nx][ny] == 0) continue;
                
                visit[nx][ny] = true;
                used[ny] = true;
                count++;
                q.add(nx);
                q.add(ny);
            }
        }
        
        for(int i = 0; i < M; i++) {
            if(used[i]) {
                A[i] += count;
            }
        }
    }
    
}