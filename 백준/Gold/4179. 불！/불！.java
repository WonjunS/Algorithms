import java.util.*;
import java.io.*;

public class Main {
    
    private static int R, C;
    private static String answer = "IMPOSSIBLE";
    private static int jx, jy;
    private static char[][] map;
    private static boolean[][] visit;
    private static int[][] T, FT;
    
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        R = Integer.parseInt(str.split(" ")[0]);
        C = Integer.parseInt(str.split(" ")[1]);
        
        map = new char[R][C];
        
        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                char c = s.charAt(j);

                if(c == 'J') {
                    jx = i;
                    jy = j;
                }
                
                map[i][j] = c;
            }
        }
        
        FT = new int[R][C];
        visit = new boolean[R][C];
        T = new int[R][C];
 
        fireBfs(); 
        
        bfs();

        System.out.println(answer); 
    }
    
    private static void fireBfs() {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] != 'F') continue;

                q.add(i);
                q.add(j);
                visit[i][j] = true;
            }
        }
        
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                if(visit[nx][ny]) continue;
                
                FT[nx][ny] = FT[x][y] + 1;
                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }
    
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        
        for(boolean[] temp : visit) {
            Arrays.fill(temp, false);
        }

        q.add(jx);
        q.add(jy);
        visit[jx][jy] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            if((x == 0 || y == 0 || x == R - 1 || y == C - 1) && (map[x][y] == '.' || map[x][y] == 'J')) {
                answer = String.valueOf(T[x][y] + 1);
                break ;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] != '.' && map[nx][ny] != 'J') continue;
                if(visit[nx][ny]) continue;
                if(FT[nx][ny] != 0 && T[x][y] + 1 >= FT[nx][ny]) continue;

                
                
                T[nx][ny] = T[x][y] + 1;
                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }
    
}
