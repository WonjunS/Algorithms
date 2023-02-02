import java.util.*;
import java.io.*;
import java.util.Queue;

public class Main {

    static int R, C;
    static int[][] dist_water, dist_hedgehog;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[R][C];
        dist_water = new int[R][C];
        dist_hedgehog = new int[R][C];
        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        bfs_water();

        bfs_hedgehog();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'D') {
                    if(dist_hedgehog[i][j] == -1) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
        }
    }

    static void bfs_water() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                dist_water[i][j] = -1;
                visit[i][j] = false;
                if(map[i][j] == '*') {
                    q.add(i);
                    q.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] != '.') continue;
                if(visit[nx][ny]) continue;

                dist_water[nx][ny] = dist_water[x][y] + 1;
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }
    }

    static void bfs_hedgehog() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                if(map[i][j] == 'S') {
                    q.add(i);
                    q.add(j);
                    dist_hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] != 'D' && map[nx][ny] != '.') continue;
                if(dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue;
                if(visit[nx][ny]) continue;

                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }
    }
}