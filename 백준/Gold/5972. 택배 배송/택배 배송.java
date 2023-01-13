import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private int idx;
        private int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static StringTokenizer st;

    static int N, M;
    static int[] dist;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        dijkstra(1);

        System.out.println(dist[N]);
    }

    static void dijkstra(int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
        for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(node.cost != dist[node.idx]) continue;

            for(Node n : adj[node.idx]) {
                if(dist[n.idx] <= dist[node.idx] + n.cost) continue;
                dist[n.idx] = dist[node.idx] + n.cost;
                pq.add(new Node(n.idx, dist[n.idx]));
            }
        }
    }
}