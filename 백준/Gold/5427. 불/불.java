import java.util.*;
import java.io.*;

public class Main {

    private static int w, h;
    private static char[][] map;
    private static int[][] times, fireTime;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static class Position {
        private int x;
        private int y;
        private int time;

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            times = new int[h][w];
            fireTime = new int[h][w];

            int x = -1;
            int y = -1;

            for(int i = 0; i < h; i++) {
                String str = br.readLine();
                for(int j = 0; j < w; j++) {
                    char c = str.charAt(j);
                    map[i][j] = c;

                    times[i][j] = Integer.MAX_VALUE;
                    if(c == '@') {
                        times[i][j] = 0;
                        x = i;
                        y = j;
                    }
                }
            }

            init();

            // for(int i = 0; i < h; i++) {
            //     for(int j = 0; j < w; j++) {
            //         System.out.print(fireTime[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            
            bfs(x, y);

            int min = Integer.MAX_VALUE;
            for(int i = 0; i < w; i++) {
                if(times[0][i] != Integer.MAX_VALUE) min = Math.min(times[0][i], min);
                if(times[h - 1][i] != Integer.MAX_VALUE) min = Math.min(times[h - 1][i], min);
            }

            for(int i = 0; i < h; i++) {
                if(times[i][0] != Integer.MAX_VALUE) min = Math.min(times[i][0], min);
                if(times[i][w - 1] != Integer.MAX_VALUE) min = Math.min(times[i][w - 1], min);
            }

            if(min == Integer.MAX_VALUE) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(min + 1).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void init() {
        PriorityQueue<Position> pq = new PriorityQueue<>((o1, o2) -> (o1.time - o2.time));

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                fireTime[i][j] = Integer.MAX_VALUE;
                if(map[i][j] == '*') {
                    fireTime[i][j] = 0;
                    pq.add(new Position(i, j, 0));
                }
            }
        }

        while(!pq.isEmpty()) {
            Position p = pq.poll();

            int x = p.x;
            int y = p.y;
            int time = p.time;

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if(map[nx][ny] == '#') continue;

                if(fireTime[nx][ny] > time + 1) {
                    fireTime[nx][ny] = time + 1;
                    pq.add(new Position(nx, ny, time + 1));
                }
            }
        }
    }

    private static void bfs(int a, int b) {
        PriorityQueue<Position> pq = new PriorityQueue<>((o1, o2) -> (o1.time - o2.time));
        pq.add(new Position(a, b, 0));

        while(!pq.isEmpty()) {
            Position p = pq.poll();

            int x = p.x;
            int y = p.y;
            int time = p.time;

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if(map[nx][ny] != '.') continue;
                if(fireTime[nx][ny] <= time + 1) continue;

                if(times[nx][ny] > time + 1) {
                    pq.add(new Position(nx, ny, time + 1));
                    times[nx][ny] = time + 1;
                }
            }
        }
    }

}