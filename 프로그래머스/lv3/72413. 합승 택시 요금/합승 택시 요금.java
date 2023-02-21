import java.util.*;

class Solution {
    
    static class Edge {
        private int idx;
        private int fare;
        
        public Edge(int idx, int fare) {
            this.idx = idx;
            this.fare = fare;
        }
    }
    
    static int answer;
    static ArrayList<Edge>[] adj;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        
        for(int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int fare = fares[i][2];
            
            adj[x].add(new Edge(y, fare));
            adj[y].add(new Edge(x, fare));
        }
        
        int[] start = new int[n + 1];
        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        
        Arrays.fill(startA, 100000 * n);
        Arrays.fill(startB, 100000 * n);
        Arrays.fill(start, 100000 * n);
        
        start = dijkstra(s, start);
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        
        answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, start[i] + startA[i] + startB[i]);
        }
        
        return answer;
    }
    
    static int[] dijkstra(int x, int[] cost) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (o1.fare - o2.fare));
        cost[x] = 0;
        pq.add(new Edge(x, 0));
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if(cost[edge.idx] != edge.fare) continue;
            for(Edge e : adj[edge.idx]) {
                if(cost[e.idx] <= cost[edge.idx] + e.fare) continue;
                    
                cost[e.idx] = cost[edge.idx] + e.fare;
                pq.add(new Edge(e.idx, cost[e.idx]));
            }
        }
        
        return cost;
    }
}