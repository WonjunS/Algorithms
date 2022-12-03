import java.util.*;

public class Main {

    static class Edge {
        private int to;
        private int dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static int N, M, A, B, C, ans;
    static boolean[] visit;
    static ArrayList<Edge>[] graph;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            graph[a].add(new Edge(b, d));
            graph[b].add(new Edge(a, d));
        }
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        for(Edge e : graph[A]) {
            visit[A] = true;
            dijkstra(e.to, e.dist, Math.max(e.dist, 0));
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    static void dijkstra(int x, int cost, int max) {
        if(x == B) {
            if(cost <= C) {
                ans = Math.min(ans, max);
            }
            return;
        }
        if(visit[x]) return;
        for(Edge e : graph[x]) {
            visit[x] = true;
            dijkstra(e.to, cost + e.dist, Math.max(e.dist, max));
            visit[x] = false;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}