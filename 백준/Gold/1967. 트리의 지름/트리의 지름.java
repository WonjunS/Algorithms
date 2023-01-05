import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private int idx;
        private int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N, ans;
    static boolean[] visit;
    static ArrayList<Node>[] adj;

    static void dfs(int x, int dim) {
        for(Node n : adj[x]) {
            if(!visit[n.idx]) {
                visit[n.idx] = true;
                dfs(n.idx, dim + n.weight);
            }
        }
        ans = Math.max(ans, dim);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }

        for(int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            visit[i] = true;
            dfs(i, 0);
        }

        System.out.println(ans);
    }
}