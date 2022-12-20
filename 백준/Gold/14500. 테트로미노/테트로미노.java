import java.util.*;

public class Main {

    static int N, M, ans;
    static int[][] board;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
    }

    static void pro() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                visit[i][j] = true;
                search(i, j, 1, board[i][j]);
                visit[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    static void search(int x, int y, int count, int total) {
        if(count == 4) {
            ans = Math.max(total, ans);
            return;
        } else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(!visit[nx][ny]) {
                    if(count == 2) {
                        visit[nx][ny] = true;
                        search(x, y, count + 1, total + board[nx][ny]);
                        visit[nx][ny] = false;
                    }
                    visit[nx][ny] = true;
                    search(nx, ny, count + 1, total + board[nx][ny]);
                    visit[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}