import java.util.*;

public class Main {

    static class Node {
        private int idx;
        private int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, n1, n2;
    static boolean[] visit;
    static ArrayList<Node>[] adj;

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }
    }

    static void pro() {
        for(int i = 0; i < M; i++) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();

            visit = new boolean[N + 1];
            visit[n1] = true;
            dfs(n1, 0);
        }

        System.out.println(sb);
    }

    static void dfs(int x, int dist) {
        if(x == n2) {
            sb.append(dist).append('\n');
            return;
        }
        for(Node n : adj[x]) {
            if(visit[n.idx]) continue;
            visit[n.idx] = true;
            dfs(n.idx, dist + n.dist);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}