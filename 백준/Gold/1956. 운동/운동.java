import java.util.*;
import java.io.*;

public class Main {

    static int INF = 2000000000;
    static int V, E, ans;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];
        for(int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
        }

        for(int k = 1; k <= V; k++) {
            for(int a = 1; a <= V; a++) {
                if(dist[a][k] == INF) continue;
                for(int b = 1; b <= V; b++) {
                    if(dist[k][b] == INF) continue;
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
            }
        }

        ans = INF;
        for(int i = 1; i <= V; i++) ans = Math.min(ans, dist[i][i]);

        if(ans == INF) ans = -1;
        System.out.println(ans);
    }
}