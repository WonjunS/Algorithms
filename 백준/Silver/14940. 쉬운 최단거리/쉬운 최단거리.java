import java.util.*;
import java.io.*;

public class Main {
    
    private static int n, m;
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[][] D, map;
    private static boolean[][] visit;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int start_x = 0, start_y = 0;
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 2) {
                    start_x = i;
                    start_y = j;
                }
                map[i][j] = x;
            }
        }
        
        D = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0) {
                    D[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        visit = new boolean[n][m];
        
        bfs(start_x, start_y);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(D[i][j] == Integer.MAX_VALUE) {
                    sb.append("-1").append(' ');
                } else {
                    sb.append(D[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    private static void bfs(int start_x, int start_y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start_x);
        q.add(start_y);
        visit[start_x][start_y] = true;
        D[start_x][start_y] = 0;

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;

                D[nx][ny] = D[x][y] + 1;
                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }
    
}