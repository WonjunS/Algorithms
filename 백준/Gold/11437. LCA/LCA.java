import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] parent, depth;
    static ArrayList<Integer>[] adj;

    static void dfs(int x, int cnt) {
        depth[x] = cnt++;
        for(int y : adj[x]) {
            if(depth[y] != 0) continue;
            dfs(y, cnt);
            parent[y] = x;
        }
    }

    static void lca(int a, int depth_a, int b, int depth_b) {
        if(depth_a > depth_b) {
            while(depth_a != depth_b) {
                depth_a--;
                a = parent[a];
            }
        } else if(depth_a < depth_b) {
            while(depth_a != depth_b) {
                depth_b--;
                b = parent[b];
            }
        }
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        sb.append(a).append('\n');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        depth = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1, 1);

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lca(a, depth[a], b, depth[b]);
        }

        System.out.println(sb);
    }
}