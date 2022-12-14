import java.util.*;

public class Main {

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

    static int N, E, v1, v2, ans;
    static final int INF = 200000000;
    static int[] D;
    static ArrayList<Edge>[] adj;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();
        adj = new ArrayList[N + 1];
        D = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = sc.nextInt();

            adj[x].add(new Edge(y, dist));
            adj[y].add(new Edge(x, dist));
        }

        v1 = sc.nextInt();
        v2 = sc.nextInt();
    }

    static void pro() {
        int route1 = 0;
        route1 += dijkstra(1, v1);
        route1 += dijkstra(v1, v2);
        route1 += dijkstra(v2, N);
        
        int route2 = 0;
        route2 += dijkstra(1, v2);
        route2 += dijkstra(v2, v1);
        route2 += dijkstra(v1, N);

        int ans = (route1 >= INF && route2 >= INF) ? -1 : Math.min(route1, route2);
        
        System.out.println(ans);
    }

    static int dijkstra(int start, int end) {
        for(int i = 1; i <= N; i++) D[i] = INF;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        D[start] = 0;

        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(info.dist != D[info.idx]) continue;
            for(Edge e : adj[info.idx]) {
                if(D[info.idx] + e.weight >= D[e.to]) continue;

                D[e.to] = D[info.idx] + e.weight;
                pq.add(new Info(e.to, D[e.to]));
            }
        }
        
        return D[end];
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}