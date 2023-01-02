import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] A, map;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        A = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
    }

    static void pro() {
        int ans = 0;

        while(true) {
            int idx = 1;
            map = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] != 0) continue;
                    bfs(i, j, idx);
                    idx++;
                }
            }
            if(idx == (N * N) + 1) break;
            ans++;
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y, int idx) {
        Queue<Integer> q = new LinkedList<>();
        int sum = A[x][y];
        int cnt = 1;
        map[x][y] = idx;
        q.add(x);
        q.add(y);

        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(Math.abs(A[nx][ny] - A[x][y]) < L ||
                        Math.abs(A[nx][ny] - A[x][y]) > R) continue;
                if(map[nx][ny] != 0) continue;
                map[nx][ny] = idx;
                q.add(nx);
                q.add(ny);
                sum += A[nx][ny];
                cnt++;
            }
        }

        int val = sum / cnt;
        relocate(val, idx);
    }

    static void relocate(int val, int idx) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == idx) {
                    A[i][j] = val;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}