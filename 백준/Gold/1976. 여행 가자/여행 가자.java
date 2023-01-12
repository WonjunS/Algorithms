import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static boolean flag;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    adj[i].add(j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int curr = Integer.parseInt(st.nextToken());
        for(int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            visit = new boolean[N + 1];
            flag = false;
            visit[curr] = true;
            dfs(curr, next);
            curr = next;
            if(!flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void dfs(int curr, int destination) {
        if(curr == destination) {
            flag = true;
            return;
        }
        for(int n : adj[curr]) {
            if(visit[n]) continue;
            visit[n] = true;
            dfs(n, destination);
        }
    }
}