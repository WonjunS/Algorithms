import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        
        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
    }
    
    static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(' ');
        
        for(int n : graph[start]) {
            if(visit[n]) continue;
            
            dfs(n);
        }
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        
        visit[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(' ');
            
            for(int n : graph[x]) {
                if(visit[n]) continue;
                
                q.add(n);
                visit[n] = true;
            }
        }
    }
    
    public static void main(String[] args) {
        input();
        dfs(V);
        for(int i = 1; i <= N; i++) visit[i] = false;
        sb.append('\n');
        bfs(V);
        
        System.out.println(sb);
    }
}