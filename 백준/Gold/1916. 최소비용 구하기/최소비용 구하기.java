import java.util.*;

public class Main {
    
    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    
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
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for(int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        start = sc.nextInt();
        end = sc.nextInt();
    }
    
    static void dijkstra(int start) {
        for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.dist - o2.dist;
            }
        });
        
        dist[start] = 0;
        pq.add(new Info(start, 0));
        
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
    
    static void pro() {
        dijkstra(start);
        System.out.println(dist[end]);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}