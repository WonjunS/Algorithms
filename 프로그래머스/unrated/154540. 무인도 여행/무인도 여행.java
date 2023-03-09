import java.util.*;

class Solution {
    
    static int N, M;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static List<Integer> answer;
    
    public List<Integer> solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        visited = new boolean[N][M];
        answer = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i].charAt(j) == 'X') continue;
                if(visited[i][j]) continue;
                bfs(maps, i, j);
            }
        }
        
        Collections.sort(answer);
        
        if(answer.size() == 0) answer.add(-1);
        
        return answer;
    }
    
    static void bfs(String[] maps, int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        q.add(b);
        visited[a][b] = true;
        
        int value = Character.getNumericValue(maps[a].charAt(b));
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx].charAt(ny) == 'X') continue;
                
                q.add(nx);
                q.add(ny);
                visited[nx][ny] = true;
                value += Character.getNumericValue(maps[nx].charAt(ny));
            }
        }
        
        answer.add(value);
    }
}