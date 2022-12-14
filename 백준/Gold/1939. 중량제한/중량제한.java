import java.util.*;

public class Main {

    static class Info {
        private int to;
        private int dist;

        public Info(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static int N, M, v1, v2;
    static ArrayList<Info>[] adj;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            adj[A].add(new Info(B, C));
            adj[B].add(new Info(A, C));
        }
        v1 = sc.nextInt();
        v2 = sc.nextInt();
    }

    static void pro() {
        int L = 1, R = 1000000000, ans = R;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                L = mid + 1;
            } else {
                R = mid - 1;
                ans = R;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int value) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        visit[v1] = true;
        q.add(v1);

        while(!q.isEmpty()) {
            int x = q.poll();
            if(x == v2) return true;
            for(Info info : adj[x]) {
                if(!visit[info.to] && info.dist >= value) {
                    visit[info.to] = true;
                    q.add(info.to);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}