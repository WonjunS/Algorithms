import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indeg;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            int n = sc.nextInt();
            int prev = sc.nextInt();
            for(int j = 1; j < n; j++) {
                int curr = sc.nextInt();
                adj[prev].add(curr);
                indeg[curr]++;
                prev = curr;
            }
        }
    }
    
    static void pro() {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int x = q.poll();
            ans.add(x);
            for(int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) q.add(y);
            }
        }
        if(ans.size() == N) {
            for(int x : ans) sb.append(x).append('\n');
        }
        else sb.append("0");
        System.out.println(sb);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}