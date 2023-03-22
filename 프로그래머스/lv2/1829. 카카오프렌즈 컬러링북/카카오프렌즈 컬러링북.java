import java.util.*;

class Solution {
    
    static int count, maxSize;
    static int[] answer;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        count = 0;
        maxSize = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 0) continue;
                if(visited[i][j]) continue;
                
                bfs(i, j, picture);
                count++;
            }
        }

        answer = new int[2];
        answer[0] = count;
        answer[1] = maxSize;
        
        return answer;
    }
    
    static void bfs(int a, int b, int[][] picture) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        q.add(b);
        visited[a][b] = true;
        
        int area = 1;
        int color = picture[a][b];
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if(nx < 0 || ny < 0 || nx >= picture.length || ny >= picture[0].length) continue;
                if(visited[nx][ny]) continue;
                if(picture[nx][ny] != color) continue;
                
                q.add(nx);
                q.add(ny);
                visited[nx][ny] = true;
                area++;
            }
        }
        
        maxSize = Math.max(maxSize, area);
    }
}