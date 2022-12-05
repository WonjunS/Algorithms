import java.util.*;

public class Main {

    static int N, M, A, B, dist;
    static int[] D;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        D = new int[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void pro() {
        dist = Integer.MAX_VALUE;
        A = 101;
        B = 102;
        for(int i = 1; i <= N - 1; i++) {
            for(int j = i + 1; j <= N; j++) {
                bfs(i, j);
                clear();
            }
        }
        System.out.println(A + " " + B + " " + dist);
    }

    static void clear() {
        for(int k = 1; k <= N; k++) {
            visit[k] = false;
            D[k] = 0;
        }
    }

    static void bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        q.add(b);
        visit[a] = true;
        visit[b] = true;

        D[a] = 0;
        D[b] = 0;

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int n : adj[x]) {
                if(visit[n]) continue;
                D[n] = D[x] + 1;
                q.add(n);
                visit[n] = true;
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += D[i] * 2;
        }
        if(sum == dist) {
            if(a < A) {
                A = a;
                B = b;
                dist = sum;
            }
        }
        if(sum < dist) {
            A = a;
            B = b;
            dist = sum;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}