import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private int x;
        private int y;
        private int cctv;

        public Point(int x, int y, int cctv) {
            this.x = x;
            this.y = y;
            this.cctv = cctv;
        }
    }

    static int N, M, ans;
    static int[][] map;
    static ArrayList<Point> coords;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coords = new ArrayList<>();
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n > 0 && n < 6) coords.add(new Point(i, j, n));
            }
        }

        ans = Integer.MAX_VALUE;

        dfs(0, map);

        System.out.println(ans);
    }

    static void dfs(int depth, int[][] map) {
        if(depth == coords.size()) {
            ans = Math.min(ans, count(map));
            return;
        }

        int cctvNum = coords.get(depth).cctv;
        int x = coords.get(depth).x;
        int y = coords.get(depth).y;
        
        int[][] tmp;

        if(cctvNum == 1) {
            tmp = copyMap(map);
            toLeft(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toRight(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toUp(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toDown(tmp, x, y);
            dfs(depth + 1, tmp);
        } else if(cctvNum == 2) {
            tmp = copyMap(map);
            toLeft(tmp, x, y);
            toRight(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toUp(tmp, x, y);
            toDown(tmp, x, y);
            dfs(depth + 1, tmp);
        } else if(cctvNum == 3) {
            tmp = copyMap(map);
            toLeft(tmp, x, y);
            toDown(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toDown(tmp, x, y);
            toRight(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toUp(tmp, x, y);
            toRight(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toLeft(tmp, x, y);
            toUp(tmp, x, y);
            dfs(depth + 1, tmp);
        } else if(cctvNum == 4) {
            tmp = copyMap(map);
            toLeft(tmp, x, y);
            toRight(tmp, x, y);
            toDown(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toLeft(tmp, x, y);
            toUp(tmp, x, y);
            toDown(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toUp(tmp, x, y);
            toRight(tmp, x, y);
            toDown(tmp, x, y);
            dfs(depth + 1, tmp);

            tmp = copyMap(map);
            toLeft(tmp, x, y);
            toUp(tmp, x, y);
            toRight(tmp, x, y);
            dfs(depth + 1, tmp);
        } else {
            tmp = copyMap(map);
            toUp(tmp, x, y);
            toLeft(tmp, x, y);
            toDown(tmp, x, y);
            toRight(tmp, x, y);
            dfs(depth + 1, tmp);
        }
    }

    static void toLeft(int[][] map, int x, int y) {
        for(int i = y - 1; i >= 0; i--) {
            if(map[x][i] == 6) return;
            if(map[x][i] > 0) continue;
            map[x][i] = -1;
        }
    }

    static void toRight(int[][] map, int x, int y) {
        for(int i = y + 1; i < M; i++) {
            if(map[x][i] == 6) return;
            if(map[x][i] > 0) continue;
            map[x][i] = -1;
        }
    }

    static void toUp(int[][] map, int x, int y) {
        for(int i = x - 1; i >= 0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] > 0) continue;
            map[i][y] = -1;
        }
    }

    static void toDown(int[][] map, int x, int y) {
        for(int i = x + 1; i < N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] > 0) continue;
            map[i][y] = -1;
        }
    }

    static int count(int[][] map) {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
}