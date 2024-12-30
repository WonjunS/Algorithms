import java.util.*;

class Solution {
    
    private static int N, M;
    private static int[][] A;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        A = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.MAX_VALUE;
            }
        }
        
        bfs(maps);
        
        int answer = A[N - 1][M - 1] == Integer.MAX_VALUE ? -1 : A[N - 1][M - 1];
        
        return answer;
    }
    
    private static void bfs(int[][] maps) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        A[0][0] = 1;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(maps[nx][ny] == 0) continue;
                if(A[nx][ny] <= A[x][y] + 1) continue;
                
                q.add(nx);
                q.add(ny);
                A[nx][ny] = A[x][y] + 1;
            }
        }
    }
}