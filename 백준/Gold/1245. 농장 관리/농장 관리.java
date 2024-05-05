import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int cnt, N, M;
    private static boolean pick;
    private static boolean[][] visited;
    private static int[][] map;
    private static int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                if(visited[x][y]) continue;

                pick = true;
                dfs(x, y);
                if(pick) cnt++;
            }
        }

        br.close();

        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int[] move : moves) {
            int nx = x + move[0];
            int ny = y + move[1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[x][y] < map[nx][ny]) pick = false;
            if(map[x][y] == map[nx][ny] && !visited[nx][ny]) dfs(nx, ny);
        }
    }

}