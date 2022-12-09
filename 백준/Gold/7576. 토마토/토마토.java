import java.util.*;

public class Main {

    static int M, N, ans;
    static int[][] A, dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        A = new int[N][M];
        dist = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }
    }

    static void pro() {
        bfs();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A[i][j] == -1) continue;
                if(dist[i][j] == -1) {
                    System.out.println("-1");
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dist[i][j] = -1;
                if(A[i][j] == 1) {
                    dist[i][j] = 0;
                    q.add(i);
                    q.add(j);
                }
            }
        }

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(dist[nx][ny] != -1) continue;
                if(A[nx][ny] == -1) continue;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(nx);
                q.add(ny);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}