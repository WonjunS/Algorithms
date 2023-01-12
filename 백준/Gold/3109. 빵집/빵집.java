import java.util.*;
import java.io.*;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        for(int i = 0; i < R; i++) {
            if(dfs(i, 0)) count++;
        }

        System.out.println(count);
    }

    static boolean dfs(int x, int y) {
        for(int i = 0; i < 3; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(map[nx][ny] == '.' && !visit[nx][ny]) {
                visit[nx][ny] = true;
                if(ny == C - 1) return true;
                if(dfs(nx, ny)) return true;
            }
        }
        return false;
    }
}