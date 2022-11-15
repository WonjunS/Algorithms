import java.util.*;

class Solution {
    
    static int max;
    static ArrayList<Integer>[] graph;
    static Map<Integer, Integer> dist;
    static boolean[] visit;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n + 1];
        dist = new HashMap<>();
        visit = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        bfs(1);
        
        for(int x : dist.keySet()) {
            if(dist.get(x) == max) answer++;
        }
        
        return answer;
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        max = Integer.MIN_VALUE;
        
        q.add(start);
        dist.put(start, 0);
        visit[start] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            
            for(int y : graph[x]) {
                if(visit[y]) continue;
                dist.put(y, dist.get(x) + 1);
                visit[y] = true;
                if(dist.get(y) >= max) max = dist.get(y);
                q.add(y);
            }
        }
    }
}