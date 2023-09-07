import java.util.*;
import java.io.*;

public class Main {
    
    private static int count;
    private static int[] order;
    private static List<Integer>[] arr;
    private static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            arr[u].add(v);
            arr[v].add(u);
        }
        
        visit = new boolean[N + 1];
        order = new int[N + 1];
        count = 1;

        for(int i = 1; i <= N; i++) {
            arr[i].sort((o1, o2) -> (o2 - o1));
        }

        dfs(R);
        
        for(int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    private static void dfs(int x) {
        order[x] = count++;
        visit[x] = true;
        
        for(int y : arr[x]) {
            if(visit[y]) continue;
            
            dfs(y);
        }
    }
    
}