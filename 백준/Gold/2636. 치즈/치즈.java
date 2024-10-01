import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int count = 0;

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                if(x == 1) count++;
            }
        }

        int hour = 1;
        int answer = 0;

        while(true) {
            int removedCount = bfs(0, 0);
            
            if(count == removedCount) {
                answer = count;
                break;
            } else {
                count -= removedCount;
            }

            hour++;
        }

        System.out.println(hour);
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        int count = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        q.add(x);
        q.add(y);

        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if(map[nx][ny] == 0) {
                    q.add(nx);
                    q.add(ny);
                } else {
                    map[nx][ny] = 0;
                    count++;
                }
            }
        }

        return count;
    }

}