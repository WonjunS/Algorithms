import java.util.*;

class Solution {
    
    static int[][] dist, board;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        dist = new int[101][101];
        board = new int[101][101];
        
        for(int i = 0; i < rectangle.length; i++) {
            int left_bottom_x = rectangle[i][0];
            int left_bottom_y = rectangle[i][1];
            int right_top_x = rectangle[i][2];
            int right_top_y = rectangle[i][3];
            
            for(int j = left_bottom_x * 2 + 1; j <= right_top_x * 2 - 1; j++) {
                for(int k = left_bottom_y * 2 + 1; k <= right_top_y * 2 - 1; k++) {
                    board[j][k] = -1;
                }
            }
            
            for(int j = left_bottom_y * 2; j <= right_top_y * 2; j++) {
                if(board[left_bottom_x * 2][j] != -1) {
                    board[left_bottom_x * 2][j] = 1;
                }
                if(board[right_top_x * 2][j] != -1) {
                    board[right_top_x * 2][j] = 1;
                }
            }
            
            for(int j = left_bottom_x * 2; j <= right_top_x * 2; j++) {
                if(board[j][left_bottom_y * 2] != -1) {
                    board[j][left_bottom_y * 2] = 1;
                }
                if(board[j][right_top_y * 2] != -1) {
                    board[j][right_top_y * 2] = 1;
                }
            }
        }
        
        bfs(characterX, characterY);
        
        answer = dist[itemX * 2][itemY * 2] / 2;
        
        return answer;
    }
    
    static void bfs(int charX, int charY) {
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(charX * 2);
        q.add(charY * 2);
        dist[charX * 2][charY * 2] = 0;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                
                if(nx < 1 || ny < 1 || nx > 100 || ny > 100) continue;
                if(board[nx][ny] != 1) continue;
                if(dist[nx][ny] != -1) continue;
                
                q.add(nx);
                q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
}