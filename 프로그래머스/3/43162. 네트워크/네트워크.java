import java.util.*;

class Solution {
    
    private static int N;
    private static List<Integer>[] connections;
    private static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        connections = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            connections[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(computers[i][j] == 0) continue;
                connections[i + 1].add(j + 1);
            }
        }
        
        N = n;
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            if(visit[i]) continue;
            answer++;
            dfs(i);
        }
        
        return answer;
    }
    
    private static void dfs(int x) {
        visit[x] = true;
        
        for(int y : connections[x]) {
            if(visit[y]) continue;
            dfs(y);
        }
    }
}