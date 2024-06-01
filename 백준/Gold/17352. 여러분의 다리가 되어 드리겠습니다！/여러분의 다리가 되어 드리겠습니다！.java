import java.util.*;
import java.io.*;

public class Main {

    private static List<Integer>[] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for(int i = 0; i <= N; i ++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(List<Integer> list : adj) {
            list.sort((o1, o2) -> (o1 - o2));
        }

        visited = new boolean[N + 1];

        dfs(1);
        
        int x = 1;
        int y = -1;
        for(int i = 2; i <= N; i++) {
            if(!visited[i]) {
                y = i;
                break;
            }
        }

        System.out.println(x + " " + y);
    }

    private static void dfs(int x) {
        visited[x] = true;

        for(int y : adj[x]) {
            if(visited[y]) continue;

            dfs(y);
        }
    }

}