import java.util.*;

public class Main {

    static int N, M;
    static int[][] A, Dy;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        Dy = new int[N][M];
        A = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
                Dy[i][j] = -1;
            }
        }
    }

    static void pro() {
        int H = dfs(0, 0);

        System.out.println(H);
    }

    static int dfs(int x, int y) {
        if(x == N - 1 && y == M - 1) {
            return 1;
        }
        if(Dy[x][y] != -1) {
            return Dy[x][y];
        }
        else {
            Dy[x][y] = 0;
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(A[nx][ny] >= A[x][y]) continue;

                Dy[x][y] += dfs(nx, ny);
            }
        }
        return Dy[x][y];
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}