import java.util.*;
import java.io.*;

public class Main {

    static class Edge {
        private int idx;
        private int weight;

        public Edge(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N, D, C;
    static int[] time;
    static ArrayList<Edge>[] adj;

    static void solve(int x) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        time[x] = 0;
        pq.add(new Edge(x, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(edge.weight != time[edge.idx]) continue;
            for(Edge e : adj[edge.idx]) {
                if(time[edge.idx] + e.weight >= time[e.idx]) continue;
                time[e.idx] = time[edge.idx] + e.weight;
                pq.add(new Edge(e.idx, time[e.idx]));
            }
        }

        int max = 0, cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(time[i] == Integer.MAX_VALUE) continue;
            max = Math.max(time[i], max);
            cnt++;
        }

        sb.append(cnt).append(" ");
        sb.append(max).append('\n');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            time = new int[N + 1];
            for(int j = 1; j <= N; j++) {
                adj[j] = new ArrayList<>();
                time[j] = Integer.MAX_VALUE;
            }
            for(int j = 1; j <= D; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                adj[b].add(new Edge(a, s));
            }
            solve(C);
        }
        System.out.println(sb);
    }
}