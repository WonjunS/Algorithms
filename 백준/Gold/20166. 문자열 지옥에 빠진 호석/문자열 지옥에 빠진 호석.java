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
        for(int i = 0; i < K; i++) {
            String s = cases[i];
            if(patterns.containsKey(s)) {
                sb.append(patterns.get(s)).append('\n');
                continue;
            }
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    char c = board[j].charAt(k);
                    if(c != s.charAt(0)) continue;
                    dfs(s, String.valueOf(c), j, k);
                }
            }
            if(!patterns.containsKey(s)) patterns.put(s, 0);
            sb.append(patterns.get(s)).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(String s, String cand, int x, int y) {
        if(s.length() == cand.length()) {
            if(cand.equals(s)) {
                patterns.put(cand, patterns.getOrDefault(cand, 0) + 1);
            }
            return;
        }
        if(!s.contains(cand)) return;
        for(int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx == -1) nx = N - 1;
            if(ny == -1) ny = M - 1;
            if(nx == N) nx = 0;
            if(ny == M) ny = 0;
            char c = board[nx].charAt(ny);
            dfs(s, cand + c, nx, ny);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}