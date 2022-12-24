import java.util.*;

public class Main {

    static class Point {
        private int x, y, dist, drill;

        public Point(int x, int y, int dist, int drill) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.drill = drill;
        }
    }

    static int N, M, ans;
    static int[][] map, visited;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void pro() {
        int ans = bfs(0, 0);

        System.out.println(ans);
    }

    static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1, 0));
        visited[x][y] = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(p.x == N - 1 && p.y == M - 1) {
                return p.dist;
            }

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(p.drill >= visited[nx][ny]) continue;
                if(map[nx][ny] == 0) {
                    q.add(new Point(nx, ny, p.dist + 1, p.drill));
                    visited[nx][ny] = p.drill;
                } else {
                    if(p.drill == 0) {
                        q.add(new Point(nx, ny, p.dist + 1, p.drill + 1));
                        visited[nx][ny] = p.drill + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}