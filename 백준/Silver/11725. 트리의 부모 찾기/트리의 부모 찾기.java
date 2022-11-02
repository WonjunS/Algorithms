import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] a;
    static int[] parent;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        a = new ArrayList[N + 1];
        parent = new int[N + 1];

        for(int i = 0; i <= N; i++) a[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            a[x].add(y);
            a[y].add(x);
        }
    }

    static void dfs(int x, int par) {
        for(int n : a[x]) {
            if(n == par) continue;
            parent[n] = x;
            dfs(n, x);
        }
    }

    static void pro() {
        dfs(1, -1);
        for(int i = 2; i <= N; i++) sb.append(parent[i]).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}