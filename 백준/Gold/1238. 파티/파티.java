import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private int idx;
        private int dist;

        public Point(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N, M, X;
    static int[] T_to, T_from;
    static ArrayList<Point>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        T_to = new int[N + 1];
        T_from = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[A].add(new Point(B, d));
        }
        for(int i = 1; i <= N; i++) {
            T_to[i] = dijkstra_to(i);
            T_from[i] = Integer.MAX_VALUE;
        }
        dijkstra_from(X);

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, T_to[i] + T_from[i]);
        }

        System.out.println(max);
    }

    static int dijkstra_to(int x) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        int[] T = new int[N + 1];
        for(int i = 1; i <= N; i++) T[i] = Integer.MAX_VALUE;
        T[x] = 0;
        pq.add(new Point(x, 0));

        while(!pq.isEmpty()) {
            Point point = pq.poll();
            if(point.idx == X) break;
            if(T[point.idx] != point.dist) continue;
            for(Point p : adj[point.idx]) {
                if(T[p.idx] <= T[point.idx] + p.dist) continue;
                T[p.idx] = T[point.idx] + p.dist;
                pq.add(new Point(p.idx, T[p.idx]));
            }
        }
        return T[X];
    }

    static void dijkstra_from(int x) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        T_from[x] = 0;
        pq.add(new Point(x, 0));

        while(!pq.isEmpty()) {
            Point point = pq.poll();

            if(T_from[point.idx] != point.dist) continue;
            for(Point p : adj[point.idx]) {
                if(T_from[p.idx] <= T_from[point.idx] + p.dist) continue;
                T_from[p.idx] = T_from[point.idx] + p.dist;
                pq.add(new Point(p.idx, T_from[p.idx]));
            }
        }
    }
}