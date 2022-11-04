import java.util.*;

public class Main {
    static int N, K;
    static int[] dist;
    static boolean[] visit;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        dist = new int[100005];
        visit = new boolean[100005];
    }
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            if(x - 1 >= 0 && !visit[x - 1]) {
                dist[x - 1] = dist[x] + 1;
                visit[x - 1] = true;
                q.add(x - 1);
            }
            if(x + 1 <= 100000 && !visit[x + 1]) {
                dist[x + 1] = dist[x] + 1;
                visit[x + 1] = true;
                q.add(x + 1);
            }
            if(x * 2 <= 100000 && !visit[x * 2]) {
                dist[x * 2] = dist[x] + 1;
                visit[x * 2] = true;
                q.add(x * 2);
            }
        }
        System.out.println(dist[K]);
    }
    
    public static void main(String[] args) {
        input();
        bfs();
    }
}