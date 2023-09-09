import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, M, R, count;
    private static int[] order;
    private static ArrayList<Integer>[] list;
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int x = q.poll(); 
            
            if(order[x] != 0) continue;
            
            order[x] = count++;
            
            for(int y : list[x]) {
                if(order[y] == 0) {
                    q.add(y);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            list[u].add(v);
            list[v].add(u);
        }
        
        for(int i = 1; i <= N; i++) {
            list[i].sort((n1, n2) -> (n1 - n2));
        }
        
        count = 1;
        order = new int[N + 1];
        
        bfs(R);
        
        for(int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}