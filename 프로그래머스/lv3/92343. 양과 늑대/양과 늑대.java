import java.util.*;

class Solution {
    
    static int answer;
    static int[] infos;
    static boolean[][][] visit;
    static ArrayList<Integer>[] adj;
    
    public int solution(int[] info, int[][] edges) {
        infos = info;
        
        adj = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            
            adj[x].add(y);
            adj[y].add(x);
        }
        
        visit = new boolean[info.length][info.length + 1][info.length + 1];
        
        dfs(0, 0, 0);
        
        return answer;
    }
    
    static void dfs(int x, int wolf, int sheep) {  
        if(infos[x] == 0) {
            sheep += 1;
        }
        if(infos[x] == 1) {
            wolf += 1;
        }
        
        if(wolf >= sheep) return;
        
        answer = Math.max(answer, sheep);
        
        for(int y : adj[x]) {
            int temp = infos[x];
            if(!visit[x][wolf][sheep]) {
                visit[x][wolf][sheep] = true;
                infos[x] = -1;
                
                dfs(y, wolf, sheep);
                
                visit[x][wolf][sheep] = false;
                infos[x] = temp;
            }
        }
    }
}