import java.util.*;

class Solution {
    
    static int N, M, K, R, C;
    static String answer;
    static boolean stop;
    static char[] pos = {'d', 'l', 'r', 'u'};
    static int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        K = k;
        R = r;
        C = c;
        
        answer = "impossible";
        
        dfs(x, y, K - 1, "");
        
        return answer;
    }
    
    static void dfs(int x, int y, int cnt, String str) {
        if(stop || cnt < 0) return;

        for(int i = 0; i < 4; i++) {
            if(stop) return;

            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            int D = Math.abs(nx - R) + Math.abs(ny - C);

            if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
            if(D > cnt || (cnt - D) % 2 == 1) continue;

            if(cnt > 0) 
                dfs(nx, ny, cnt - 1, str + pos[i]);

            if(cnt == 0 && nx == R && ny == C) {
                stop = true;
                answer = str + pos[i];
                return;
            }
        }
        
    }
}