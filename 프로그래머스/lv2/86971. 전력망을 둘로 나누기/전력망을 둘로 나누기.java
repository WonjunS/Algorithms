import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] wires) {
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            bfs(a, b, n);
        }
        
        return answer;
    }
    
    static void bfs(int a, int b, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        int count = 1;
        
        q.add(a);
        visit[a] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            
            for(int y : adj[x]) {
                if(y == b) continue;
                if(visit[y]) continue;
                q.add(y);
                visit[y] = true;
                count++;
            }
        }
        
        int rest = n - count;
        answer = Math.min(answer, Math.abs(count - rest));
    }
}