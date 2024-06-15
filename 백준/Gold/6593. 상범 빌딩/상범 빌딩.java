import java.util.*;
import java.io.*;

public class Main {

    private static int L, R, C, start_x, start_y, start_z, exit_x, exit_y, exit_z;
    private static char[][][] map;
    private static int[][][] times;
    private static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    private static class Position {
        private int x;
        private int y;
        private int z;
        private int time;

        public Position(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            times = new int[L][R][C];

            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String str = br.readLine();

                    for(int k = 0; k < C; k++) {
                        char c = str.charAt(k);
                        map[i][j][k] = c;
                        times[i][j][k] = Integer.MAX_VALUE;

                        if(c == 'S') {
                            start_x = i;
                            start_y = j;
                            start_z = k;
                        }
                        if(c == 'E') {
                            exit_x = i;
                            exit_y = j;
                            exit_z = k;
                        }
                    }
                }

                br.readLine();
            }

            bfs();

            if(times[exit_x][exit_y][exit_z] == Integer.MAX_VALUE) {
                sb.append("Trapped!").append('\n');
            } else {
                int time = times[exit_x][exit_y][exit_z];
                sb.append("Escaped in ").append(time).append(" minute(s).").append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static void bfs() {
        PriorityQueue<Position> pq = new PriorityQueue<>((o1, o2) -> (o1.time - o2.time));
        times[start_x][start_y][start_z] = 0;
        pq.add(new Position(start_x, start_y, start_z, times[start_x][start_y][start_z]));

        while(!pq.isEmpty()) {
            Position position = pq.poll();

            int x = position.x;
            int y = position.y;
            int z = position.z;
            int time = position.time;

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                int nz = z + dir[2];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C) continue;
                if(map[nx][ny][nz] == '#') continue;
                if(times[nx][ny][nz] > time + 1) {
                    times[nx][ny][nz] = time + 1;
                    pq.add(new Position(nx, ny, nz, times[nx][ny][nz]));
                }
            }
        }
    }

}