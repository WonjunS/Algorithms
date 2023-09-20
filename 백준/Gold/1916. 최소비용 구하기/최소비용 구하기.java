import java.util.*;
import java.io.*;

public class Main {
    
    private static class Edge {
        private int idx;
        private int dist;
        
        public Edge(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    
    private static int N, M;
    private static List<Edge>[] edges;
    private static int[] dist;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        edges = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            edges[from].add(new Edge(to, weight));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dijkstra(start);
        
        System.out.println(dist[end]);
    }
    
    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if(edge.dist != dist[edge.idx]) continue;
            
            for(Edge e : edges[edge.idx]) {
                if(dist[edge.idx] + e.dist >= dist[e.idx]) continue;
                
                dist[e.idx] = dist[edge.idx] + e.dist;
                
                pq.add(new Edge(e.idx, dist[e.idx]));
            }
        }
    }
    
}