import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M, count, ans;
    static boolean isSeparated;
    static int[][] map, count_map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
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
        
        isSeparated = false;
        while(true) {
            ans++;
            count_map = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 0) continue;
                    count(i, j);
                }
            }
            
            subtract();
            
            visit = new boolean[N][M];
            count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 0) continue;
                    if(visit[i][j]) continue;
                    bfs(i, j);
                    count++;
                }
            }
            
            if(count > 1) isSeparated = true;
            if(count == 1) continue;
            else break;
        }
        
        if(!isSeparated) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
    
    static void count(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] == 0) count_map[x][y]++;
        }
    }
    
    static void subtract() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) continue;
                if(map[i][j] - count_map[i][j] < 0) {
                    map[i][j] = 0;
                    continue;
                } else {
                    map[i][j] = map[i][j] - count_map[i][j];
                }
            }
        }
    }
    
    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }
    }
}