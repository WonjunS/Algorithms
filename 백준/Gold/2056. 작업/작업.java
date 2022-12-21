import java.util.*;

public class Main {

    static int N, ans;
    static ArrayList<Integer>[] adj;
    static int[] indeg, T, D;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        T = new int[N + 1];
        D = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            int T_ = sc.nextInt();
            T[i] = T_;
            int n = sc.nextInt();
            for(int j = 0; j < n; j++) {
                int K = sc.nextInt();
                adj[K].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro() {
        solve();

        for(int d : D) {
            ans = Math.max(ans, d);
        }

        System.out.println(ans);
    }

    static void solve() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) {
                q.add(i);
                D[i] = T[i];
            }
        }

        while(!q.isEmpty()) {
            int m = q.poll();
            for(int n : adj[m]) {
                indeg[n]--;
                if(indeg[n] == 0) q.add(n);
                D[n] = Math.max(D[n], D[m] + T[n]);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}