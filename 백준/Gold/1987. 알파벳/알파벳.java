import java.util.*;

public class Main {

    static int R, C, ans;
    static boolean[][] visit;
    static String[] S;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        S = new String[R];
        visit = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            S[i] = sc.next();
        }
    }

    static void pro() {
        dfs("", 0, 0);

        System.out.println(ans);
    }

    static void dfs(String s, int x, int y) {
        if(x < 0 || y < 0 || x >= R || y >= C) {
            ans = Math.max(ans, s.length());
            return;
        }
        if(s.contains(String.valueOf(S[x].charAt(y)))) {
            ans = Math.max(ans, s.length());
            return;
        }
        if(visit[x][y]) {
            ans = Math.max(ans, s.length());
            return;
        }
        for(int i = 0; i < 4; i++) {
            visit[x][y] = true;
            dfs(s + S[x].charAt(y), x + dir[i][0], y + dir[i][1]);
            visit[x][y] = false;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}