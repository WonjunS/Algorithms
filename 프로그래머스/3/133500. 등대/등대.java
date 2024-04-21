import java.util.*;

class Solution {
    
    private static int answer;
    private static boolean[] lightOn;
    private static List<Integer>[] adj;
    
    public int solution(int n, int[][] lighthouse) {
        adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] arr : lighthouse) {
            int a = arr[0];
            int b = arr[1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        Arrays.stream(adj)
            .forEach(list -> list.sort((o1, o2) -> o1 - o2));
        
        lightOn = new boolean[n + 1];
        
        dfs(1, 1);
        
        return answer;
    }
    
    private static void dfs(int curr, int parent) {
        for(int x : adj[curr]) {
            if(x == parent) continue;
            
            dfs(x, curr);
            
            if(lightOn[x] == false && lightOn[curr] == false) {
                lightOn[curr] = true;
                answer++;
            }
        }
    }
}