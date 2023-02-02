import java.util.*;
import java.io.*;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] map, dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j - 1));
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dist[N][M]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        dist[1][1] = 0;
        q.add(1);
        q.add(1);

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(map[nx][ny] == 1 && dist[x][y] + 1 < dist[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(nx);
                    q.add(ny);
                }
                if(map[nx][ny] == 0 && dist[x][y] < dist[nx][ny]) {
                    dist[nx][ny] = dist[x][y];
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
    }
}