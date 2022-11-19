import java.util.*;

class Solution {
    static class Edge {
        private int to;
        private int weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static class Info {
        private int idx;
        private int dist;
        
        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    
    static int[] dist;
    static ArrayList<Edge>[] edges;
    
    public int solution(int N, int[][] road, int K) {
        int answer = -1;
        
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        for(int i = 0; i < road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int weight = road[i][2];
            
            edges[x].add(new Edge(y, weight));
            edges[y].add(new Edge(x, weight));
        }
        
        dijkstra(1);
        
        for(int d : dist) {
            if(d <= K) answer++;
        }

        return answer;
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
         
        pq.add(new Info(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            
            if(dist[info.idx] != info.dist) continue;
            
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }
}