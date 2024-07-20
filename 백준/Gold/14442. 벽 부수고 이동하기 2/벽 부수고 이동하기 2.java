import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, K, answer;
    private static char[][] map;
    private static int[][] visit;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        answer = -1;

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visit[0][0] = 0;
        q.add(new int[]{0, 0, 1, 0});

        while(!q.isEmpty()) {
            int[] A = q.poll();
            int x = A[0];
            int y = A[1];
            int time = A[2];

            if(x == N - 1 && y == M - 1) {
                answer = time;
                return;
            }

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                int cnt = A[3];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == '1' && cnt == K) continue;
                
                if(map[nx][ny] == '1') cnt++;

                if(visit[nx][ny] <= cnt) continue;
                visit[nx][ny] = cnt;
                q.add(new int[]{nx, ny, time + 1, cnt});
                
            }
        }
    }

}