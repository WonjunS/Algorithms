import java.util.*;

class Solution {
    
    static int answer;
    static boolean[][] isErasable;
    static ArrayList<Character>[] adj;
    
    public int solution(int m, int n, String[] board) {
        isErasable = new boolean[m][n];
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                adj[j].add(board[i].charAt(j));
            }
        }
        
        while(true) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    isErasable[i][j] = false;
                }
            }
            
            for(int i = m - 1; i > 0; i--) {
                for(int j = n - 1; j > 0; j--) {
                    if(adj[j].get(i) == '*') continue;
                    check(m, n, i, j);
                }
            }
            
            int count = erase(m, n);
            answer += count;
            
            if(count == 0) break;
        }
        
        return answer;
    }
    
    static void check(int m, int n, int x, int y) {
        int[][] dir = {{0, 0}, {-1, 0}, {0, -1}, {-1, -1}};
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            
            if(adj[y].get(x) != adj[ny].get(nx)) return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            
            isErasable[nx][ny] = true;
        }
    }
    
    static int erase(int m, int n) {
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = m - 1; j >= 0; j--) {
                if(isErasable[j][i]) {
                    adj[i].remove(j);
                    cnt++;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            while(adj[i].size() < m) adj[i].add('*');
        }
        
        return cnt;
    }
}