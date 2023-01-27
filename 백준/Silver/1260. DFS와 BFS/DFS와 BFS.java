import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            adj[x].add(y);
            adj[y].add(x);
        }
        
        for(int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        
        visit = new boolean[N + 1];
        dfs(V);
        
        for(int i = 1; i <= N; i++) visit[i] = false;
        sb.append('\n');
        
        bfs(V);
        
        System.out.println(sb);
    }
    
    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        
        for(int y : adj[x]) {
            if(visit[y]) continue;
            
            dfs(y);
        }
    }
    
    static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        visit = new boolean[N + 1];
        visit[V] = true;
        q.add(V);
        
        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(' ');
            
            for(int y : adj[x]) {
                if(visit[y]) continue;
                
                visit[y] = true;
                q.add(y);
            }
        }
        
        sb.append('\n');
    }
}