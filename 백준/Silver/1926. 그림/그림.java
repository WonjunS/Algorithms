import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, cnt, area, maxArea;
    private static char[][] map;
    private static boolean[][] visit;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        visit = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == '0') continue;
                if(visit[i][j]) continue;

                area = 0;
                // dfs(i, j);
                bfs(i, j);
                cnt++;
                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(cnt);
        System.out.println(maxArea);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        area++;

        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(map[nx][ny] == '0') continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;
        area++;

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            x = arr[0];
            y = arr[1];

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == '0') continue;
                if(visit[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                area++;
            }
        }
    }

}