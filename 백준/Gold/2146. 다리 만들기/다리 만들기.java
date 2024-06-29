import java.util.*;
import java.io.*;

public class Main {

    private static int answer, N;
    private static boolean[][] visit;
    private static int[][] map;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static class Island {
        private int x;
        private int y;
        private int dist;

        public Island(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][N];
        int num = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0 || visit[i][j]) continue;
                setIslandNumber(i, j, num);
                num++;
            }
        }

        answer = Integer.MAX_VALUE;
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0 || visit[i][j]) continue;
                setBridge(i, j, map[i][j]);
                visit = new boolean[N][N];
            }
        }

        System.out.println(answer);
    }

    private static void setIslandNumber(int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = num;
        visit[x][y] = true;

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            x = arr[0];
            y = arr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(map[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                map[nx][ny] = num;
            }
        }
    }

    private static void setBridge(int x, int y, int num) {
        Queue<Island> q = new LinkedList<>();
        int dist = 0;
        q.add(new Island(x, y, dist));
        visit[x][y] = true;
 
        while(!q.isEmpty()) {
            Island island = q.poll();
            x = island.x;
            y = island.y;
            dist = island.dist;
  
            if(dist >= answer) continue;

            for(int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(map[nx][ny] == num) continue;
                if(visit[nx][ny]) continue;

                if(map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    q.add(new Island(nx, ny, dist + 1));
                } else {
                    answer = Math.min(answer, dist);
                }
            }
        }
    }

}