import java.util.*;

public class Main {

    static class Edge {
        private int idx;
        private int dist;

        public Edge(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static StringBuilder sb = new StringBuilder();

    static int V, E, K;
    static int[] dist;
    static ArrayList<Edge>[] adj;

    static void input() {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        dist = new int[V + 1];
        adj = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        K = sc.nextInt();
        for(int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            adj[a].add(new Edge(b, d));
        }
    }

    static void pro() {
        dijkstra(K);

        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(int k) {
        for(int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        dist[k] = 0;
        pq.add(new Edge(k, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(dist[edge.idx] != edge.dist) continue;
            for(Edge e : adj[edge.idx]) {
                if(dist[edge.idx] + e.dist >= dist[e.idx]) continue;
                dist[e.idx] = dist[edge.idx] + e.dist;
                pq.add(new Edge(e.idx, dist[e.idx]));
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}