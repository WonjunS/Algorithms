import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, count, max;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
            }
        }
        
        max = 0;
        
        for(int h = 0; h <= 100; h++) {
            visit = new boolean[N][N];
            count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {  
                    if(visit[i][j]) continue;
                    if(map[i][j] <= h) continue;
                    
                    dfs(i, j, h);
                    count++;
                }
            }
            
            max = Math.max(count, max);
        }
        
        System.out.println(max);
        
    }
    
    private static void dfs(int x, int y, int h) {
        visit[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visit[nx][ny]) continue;
            if(map[nx][ny] <= h) continue;
            
            dfs(nx, ny, h);
        }
    }
    
}