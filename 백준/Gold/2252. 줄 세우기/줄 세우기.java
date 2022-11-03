import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] graph;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        indeg = new int[N + 1];
        graph = new ArrayList[N + 1];
        
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            indeg[y]++;
        }
    }
    
    static void pro() {
        Deque<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(' ');
            for(int y : graph[x]) {
                indeg[y]--;
                if(indeg[y] == 0) q.add(y);
            }
        }
        
        System.out.println(sb);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}