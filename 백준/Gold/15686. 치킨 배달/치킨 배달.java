import java.util.*;

public class Main {

    static int N, M, ans;
    static int[][] board, points;
    static boolean[][] visit;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][N];
        points = new int[M + 1][2];
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        select(0, 0, 1);
        System.out.println(ans);
    }

    static void select(int x, int y, int idx) {
        if(idx == M + 1) {
            calc();
            return;
        }
        for(int i = x; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 2) continue;
                if(visit[i][j]) continue;

                points[idx][0] = i;
                points[idx][1] = j;
                visit[i][j] = true;
                select(i, j, idx + 1);
                points[idx][0] = 0;
                points[idx][1] = 0;
                visit[i][j] = false;
            }
        }
    }

    static void calc() {
        int dist = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 1) continue;
                int d = Integer.MAX_VALUE;
                for(int k = 1; k <= M; k++) {
                    int x = points[k][0];
                    int y = points[k][1];

                    d = Math.min(d, Math.abs(x - i) + Math.abs(y - j));
                }
                dist += d;
            }
        }
        ans = Math.min(ans, dist);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}