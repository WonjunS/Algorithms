import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] computers) {
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            dfs(i);
            answer++;
        }
        
        return answer;
    }
    
    private static void dfs(int x) {
        visited[x] = true;
        
        for(int y : adj[x]) {
            if(visited[y]) continue;
            
            dfs(y);
        }
    }
}