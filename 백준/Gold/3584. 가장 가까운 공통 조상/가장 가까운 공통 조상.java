import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N;
    static int[] depth, parent;
    static boolean[] appeared;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());

            adj = new ArrayList[N + 1];
            parent = new int[N + 1];
            depth = new int[N + 1];
            appeared = new boolean[N + 1];
            for(int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i = 1; i <= N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                appeared[b] = true;

                adj[a].add(b);
            }
            int root = -1;
            for(int i = 1; i <= N; i++) {
                if(!appeared[i]) {
                    root = i;
                    break;
                }
            }

            dfs(root, 1);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lca(a, depth[a], b, depth[b]);
        }

        System.out.println(sb);
    }

    static void dfs(int x, int cnt) {
        depth[x] = cnt;
        for(int y : adj[x]) {
            parent[y] = x;
            dfs(y, cnt + 1);
        }
    }

    static void lca(int a, int depth_a, int b, int depth_b) {
        if(depth_a > depth_b) {
            while(depth_a > depth_b) {
                depth_a--;
                a = parent[a];
            }
        }
        if(depth_a < depth_b) {
            while(depth_a < depth_b) {
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
}