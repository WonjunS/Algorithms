import java.util.*;
import java.io.*;

public class Main {

    static class Bead {
        private int rx;
        private int ry;
        private int bx;
        private int by;
        private int count;

        public Bead(int red_x, int red_y, int blue_x, int blue_y, int count) {
            this.rx = red_x;
            this.ry = red_y;
            this.bx = blue_x;
            this.by = blue_y;
            this.count = count;
        }
    }

    static int N, M, hole_x, hole_y;
    static String[][] boat;
    static boolean[][][][] visit;
    static Bead blue, red;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1][M + 1][N + 1][M + 1];
        boat = new String[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                char c = str.charAt(j - 1);
                boat[i][j] = String.valueOf(c);
                if(c == 'O') {
                    hole_x = i;
                    hole_y = j;
                }
                if(c == 'B') {
                    blue = new Bead(0, 0, i, j, 0);
                }
                if(c == 'R') {
                    red = new Bead(i, j, 0, 0, 0);
                }
            }
        }

        int ans = bfs();

        System.out.println(ans);
    }

    static int bfs() {
        Queue<Bead> q = new LinkedList<>();
        q.add(new Bead(red.rx, red.ry, blue.bx, blue.by, 1));
        visit[red.rx][red.ry][blue.bx][blue.by] = true;

        while(!q.isEmpty()) {
            Bead b = q.poll();

            int curRx = b.rx;
            int curRy = b.ry;
            int curBx = b.bx;
            int curBy = b.by;
            int cnt = b.count;

            if(cnt > 10) {
                return -1;
            }
            for(int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while(!boat[newRx + dir[i][0]][newRy + dir[i][1]].equals("#")) {
                    newRx += dir[i][0];
                    newRy += dir[i][1];

                    if(newRx == hole_x && newRy == hole_y) {
                        isRedHole = true;
                        break;
                    }
                }
                while(!boat[newBx + dir[i][0]][newBy + dir[i][1]].equals("#")) {
                    newBx += dir[i][0];
                    newBy += dir[i][1];

                    if(newBx == hole_x && newBy == hole_y) {
                        isBlueHole = true;
                        break;
                    }
                }
                if(isBlueHole) continue;

                if(isRedHole && !isBlueHole) {
                    return cnt;
                }

                if(newRx == newBx && newRy == newBy) {
                    if(i == 0) {
                        if(curRx < curBx) newRx -= 1;
                        else newBx -= 1;
                    } else if(i == 1) {
                        if(curRy < curBy) newRy -= 1;
                        else newBy -= 1;
                    } else if(i == 2) {
                        if(curRx > curBx) newRx += 1;
                        else newBx += 1;
                    } else {
                        if(curRy > curBy) newRy += 1;
                        else newBy += 1;
                    }
                }

                if(!visit[newRx][newRy][newBx][newBy]) {
                    visit[newRx][newRy][newBx][newBy] = true;
                    q.add(new Bead(newRx, newRy, newBx, newBy, cnt + 1));
                }
            }
        }
        return -1;
    }
}