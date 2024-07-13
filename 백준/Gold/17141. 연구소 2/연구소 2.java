import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, answer;
    private static int[] idxArr;
    private static int[][] map;
    private static List<int[]> list;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j = 0; j < arr.length; j++) {
                int state = Integer.parseInt(arr[j]);
                map[i][j] = state;
                if(state == 2) {
                    int[] coord = new int[]{i, j};
                    list.add(coord);
                }
            }
        }

        idxArr = new int[M];
        answer = Integer.MAX_VALUE;

        dfs(0, 0);

        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int idx) {
        if(idx == M) {
            bfs();
            return;
        }

        for(int i = x; i < list.size(); i++) {
            idxArr[idx] = i;
            dfs(i + 1, idx + 1);
            idxArr[idx] = -1;
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] times = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int state = map[i][j];
                if(state == 1) {
                    times[i][j] = -1;
                } else {
                    times[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < idxArr.length; i++) {
            int idx = idxArr[i];
            int x = list.get(idx)[0];
            int y = list.get(idx)[1];
            q.add(new int[]{x, y});
            times[x][y] = 0;
        }

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int time = times[x][y];

            for(int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(times[nx][ny] == -1) continue;
                if(times[nx][ny] > time + 1) {
                    times[nx][ny] = time + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int maxTime = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(times[i][j] == -1) continue;
                if(times[i][j] == Integer.MAX_VALUE) {
                    maxTime = -1;
                }
                maxTime = Math.max(maxTime, times[i][j]);
            }
        }

        if(maxTime != -1) {
            answer = Math.min(maxTime, answer);
        }
    }

}