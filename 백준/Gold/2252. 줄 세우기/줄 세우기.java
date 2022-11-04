import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indeg;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }
    }
    
    static void pro() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(' ');
            for(int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) q.add(y);
            }
        }
        System.out.println(sb);
    }
    
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}