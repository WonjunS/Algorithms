import java.util.*;

class Solution {
    
    private static class Edge {
        private int idx;
        private int time;
        
        public Edge(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    
    private static int[] times;
    private static List<Edge>[] edges;
    
    public List<Integer> solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answer = new ArrayList<>();
        
        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            
            edges[x].add(new Edge(y, 1));
            edges[y].add(new Edge(x, 1));
        }
        
        times = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            times[i] = Integer.MAX_VALUE;
        }
        
        dijkstra(destination);
        
        for(int i = 0; i < sources.length; i++) {
            int source = sources[i];
            int time = times[source];
            
            if(time == Integer.MAX_VALUE) {
                answer.add(-1);
            } else {
                answer.add(time);
            }
        }
        
        return answer;
    }
    
    private static void dijkstra(int x) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (o1.time - o2.time));
        pq.add(new Edge(x, 0));
        
        times[x] = 0;
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if(times[edge.idx] != edge.time) continue;
            
            for(Edge e : edges[edge.idx]) {
                if(times[e.idx] <= times[edge.idx] + e.time) continue;
                
                times[e.idx] = times[edge.idx] + e.time;
                pq.add(new Edge(e.idx, times[e.idx]));
            }
        }
    }
    
}