import java.util.*;
import java.io.*;

public class Main {
    
    static StringTokenizer st;

    static int N, dist;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void pro() {
        visited[1] = true;
        dfs(1, 0);

        if(dist % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }

    static void dfs(int x, int depth) {
        boolean flag = true;
        for(int y : adj[x]) {
            if(visited[y]) continue;
            visited[y] = true;
            flag = false;
            dfs(y, depth + 1);
        }
        if(flag) {
            dist += depth % 2;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}