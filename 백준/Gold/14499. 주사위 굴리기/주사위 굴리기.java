import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, x, y, K;
    private static int[] dice;
    private static int[][] map;
    private static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        x = Integer.parseInt(arr[2]);
        y = Integer.parseInt(arr[3]);
        K = Integer.parseInt(arr[4]);

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }

        dice = new int[7];

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());

            int nx = x + dirs[cmd - 1][0];
            int ny = y + dirs[cmd - 1][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            x = nx;
            y = ny;

            // 1. 동쪽 (1 - 4 - 6 - 3)
            if(cmd == 1) {
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
            }

            // 2. 서쪽 (1 - 3 - 6 - 4)
            else if(cmd == 2) {
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
            }

            // 3. 북쪽 (1 - 5 - 6 - 2)
            else if(cmd == 3) {
                int tmp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
            }

            // 4. 남쪽 (1 - 2 - 6 - 5)
            else if(cmd == 4) {
                int tmp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
            }

            // 이동한 칸에 쓰여있는 수가 0인 경우
            if(map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } 
            // 0이 아닌 경우
            else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            sb.append(dice[1]).append('\n');
        }

        System.out.println(sb.toString());
    }

}