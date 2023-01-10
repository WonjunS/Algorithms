import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    static int N, M;
    static int[] indeg;
    static boolean[][] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());

            indeg = new int[N + 1];
            edges = new boolean[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                indeg[num] = i;

                for(int j = 1; j <= N; j++) {
                    if(j != num && !edges[j][num]) {
                        edges[num][j] = true;
                    }
                }
            }

            M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(!edges[a][b]) {
                    edges[a][b] = true;
                    edges[b][a] = false;
                    indeg[a]--;
                    indeg[b]++;
                } else {
                    edges[a][b] = false;
                    edges[b][a] = true;
                    indeg[a]++;
                    indeg[b]--;
                }
            }
            System.out.println(topologicalSort());
        }
    }

    static String topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) q.add(i);
        }

        for(int i = 1; i <= N; i++) {
            if(q.size() == 0) return "IMPOSSIBLE";
            if(q.size() > 1) return "?";

            int x = q.poll();
            sb.append(x).append(' ');

            for(int k = 1; k <= N; k++) {
                if(edges[x][k]) {
                    indeg[k]--;
                    if(indeg[k] == 0) q.add(k);
                }
            }
        }
        
        return sb.toString();
    }
}