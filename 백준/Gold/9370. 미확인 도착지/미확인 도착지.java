import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private int idx;
        private int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int INF = (int) 1e9;
    static int N, M, T, S, G, H;
    static int[] dist;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            dist = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
                dist[i] = INF;
            }

            for(int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b, d));
                adj[b].add(new Node(a, d));
            }

            dijkstra(S);

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i <= T; i++) {
                int x = Integer.parseInt(br.readLine());

                int route1 = 0;
                route1 += dijkstra(S, G);
                route1 += dijkstra(G, H);
                route1 += dijkstra(H, x);

                int route2 = 0;
                route2 += dijkstra(S, H);
                route2 += dijkstra(H, G);
                route2 += dijkstra(G, x);

                if(Math.min(route1, route2) <= dist[x]) list.add(x);
            }

            Collections.sort(list);

            for(int val : list) sb.append(val).append(' ');
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra(int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(node.dist != dist[node.idx]) continue;

            for(Node n : adj[node.idx]) {
                if(dist[n.idx] <= dist[node.idx] + n.dist) continue;
                dist[n.idx] = dist[node.idx] + n.dist;
                pq.add(new Node(n.idx, dist[n.idx]));
            }
        }
    }

    static int dijkstra(int from, int to) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        int[] dist_T = new int[N + 1];
        for(int i = 1; i <= N; i++) dist_T[i] = INF;
        pq.add(new Node(from, 0));
        dist_T[from] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            
            if(dist_T[node.idx] != node.dist) continue;

            for(Node n : adj[node.idx]) {
                if(dist_T[n.idx] <= dist_T[node.idx] + n.dist) continue;
                dist_T[n.idx] = dist_T[node.idx] + n.dist;
                pq.add(new Node(n.idx, dist_T[n.idx]));
            }
        }

        return dist_T[to];
    }
}