import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static String[] board, cases;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static HashMap<String, Integer> patterns;

    static void input() {
        Scanner sc = new Scanner(System.in);
        patterns = new HashMap<>();

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        board = new String[N];
        cases = new String[K];
        for(int i = 0; i < N; i++) {
            board[i] = sc.next();
        }

        for(int i = 0; i < K; i++) {
            cases[i] = sc.next();
        }
    }

    static void pro() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                char c = board[i].charAt(j);
                dfs(String.valueOf(c), i, j);
            }
        }
        for(int i = 0; i < K; i++) {
            String s = cases[i];
            if(patterns.containsKey(s)) sb.append(patterns.get(s)).append('\n');
            else sb.append(0).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(String s, int x, int y) {
        patterns.put(s, patterns.getOrDefault(s, 0) + 1);
        if(s.length() == 5) return;
        for(int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx == -1) nx = N - 1;
            if(ny == -1) ny = M - 1;
            if(nx == N) nx = 0;
            if(ny == M) ny = 0;
            char c = board[nx].charAt(ny);
            dfs(s + c, nx, ny);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}