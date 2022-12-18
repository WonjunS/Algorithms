import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] indeg, time, ans;
    static ArrayList<Integer>[] adj;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        indeg = new int[N + 1];
        time = new int[N + 1];
        ans = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            while(st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if(n == -1) continue;
                else {
                    adj[n].add(i);
                    indeg[i]++;
                }
            }
        }
    }

    static void pro() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) {
                q.add(i);
                ans[i] = time[i];
            }
        }

        while(!q.isEmpty()) {
            int x = q.poll();
            for(int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) q.add(y);
                ans[y] = Math.max(ans[y], ans[x] + time[y]);
            }
        }

        for(int i = 1; i <= N; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}