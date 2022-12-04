import java.util.*;

public class Main {

    static class Info {
        private int idx;
        private long dist;

        public Info(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N, M, A, B;
    static long C;
    static long[] d;
    static ArrayList<Info>[] adj;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextLong();

        d = new long[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            adj[a].add(new Info(b, d));
            adj[b].add(new Info(a, d));
        }
    }

    static void pro() {
        long L = 1, R = 1000000001, ans = -1;
        while(L <= R) {
            long mid = (L + R) / 2;
            if(dijkstra(mid)) {
                ans = mid;
                R = mid - 1;
            } else L = mid + 1;
        }
        System.out.println(ans);
    }

    static boolean dijkstra(long x) {
        for(int i = 1; i <= N; i++) d[i] = Long.MAX_VALUE;
        d[A] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
        pq.add(new Info(A, 0));
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(d[info.idx] != info.dist) continue;
            for(Info edge : adj[info.idx]) {
                if(edge.dist > x) continue;
                if(d[edge.idx] > d[info.idx] + edge.dist) {
                    d[edge.idx] = d[info.idx] + edge.dist;
                    pq.add(new Info(edge.idx, d[edge.idx]));
                }
            }
        }

        return d[B] <= C;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}