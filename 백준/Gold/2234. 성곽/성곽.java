import java.util.*;
import java.io.*;

public class Main {

    private static int M, N, maxArea, count;
    private static int[][] map;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[][] roomNum;
    private static boolean[][] visit;
    private static Map<Integer, Integer> roomCount;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
            }
        }

        visit = new boolean[N][M];
        roomNum = new int[N][M];
        roomCount = new HashMap<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visit[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        int maxArea2 = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < 4; k++) {
                    int nx = i + dirs[k][0];
                    int ny = j + dirs[k][1];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(roomNum[i][j] == roomNum[nx][ny]) continue;
                    maxArea2 = Math.max(maxArea2, roomCount.get(roomNum[i][j]) + roomCount.get(roomNum[nx][ny]));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
        System.out.println(maxArea2);
    }

    private static boolean moveAvailable(int k, int dir) {
        String str = "";
        int n = k;
        while(n > 0) {
            int t = n % 2;
            str = t + str;

            n /= 2;
        }

        int length = str.length();
        for(int i = 0; i < 4 - length; i++) {
            str = "0" + str;
        }

        return str.substring(dir, dir + 1).equals("0");
    }

    private static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(x);
        q.add(y);
        roomNum[x][y] = count;

        int area = 1;

        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(moveAvailable(map[x][y], i)) {
                    visit[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    area++;
                    roomNum[nx][ny] = count;
                }
            }
        }

        maxArea = Math.max(area, maxArea);
        roomCount.put(count, area);
    }

}