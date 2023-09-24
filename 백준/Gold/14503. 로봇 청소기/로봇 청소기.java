import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, M, r, c, d;
    private static int[][] map;
    private static boolean[][] cleaned;
    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaned = new boolean[N][M];
        
        boolean flag = true;
        int curr_r = r;
        int curr_c = c;
        int curr_dir = d;
        while(flag) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(!cleaned[curr_r][curr_c]) {
                cleaned[curr_r][curr_c] = true;
            }
            
            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if(noBlank(curr_r, curr_c)) {
                // 1) 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 
                //    한 칸 후진하고 1번으로 돌아간다.
                if(canGoBack(curr_r, curr_c, curr_dir)) {
                    curr_r = curr_r + dirs[(curr_dir + 2) % 4][0];
                    curr_c = curr_c + dirs[(curr_dir + 2) % 4][1];
                    continue;
                }
            
                // 2) 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                else {
                    break;
                }
            }

            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            // 1) 반시계 방향으로 90도 회전한다.
            // 현재 북쪽 방향인 경우
            if(curr_dir == 0) {
                curr_dir = 3;
            } 
            // 그 외의 방향인 경우
            else {
                curr_dir = curr_dir - 1;
            }
            
            // 2) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            if(isNotCleaned(curr_r, curr_c, curr_dir)) {
                curr_r = curr_r + dirs[curr_dir][0];
                curr_c = curr_c + dirs[curr_dir][1];
            }
            
            // 3) 1번으로 돌아간다.
            continue;
        }
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(cleaned[i][j]) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
    
    // 주변 4칸 중에 청소되지 않은 칸이 있는지 확인
    private static boolean noBlank(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] == 1) continue;
            if(!cleaned[nx][ny]) {
                return false;
            }
        }
        
        return true;
    }
    
    // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있는지 확인
    private static boolean canGoBack(int x, int y, int dir) {
        int nx = x + dirs[(dir + 2) % 4][0];
        int ny = y + dirs[(dir + 2) % 4][1];
        
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return false;
        }
        
        if(map[nx][ny] == 1) {
            return false;
        }
        
        return true;
    }
    
    // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인지 확인
    private static boolean isNotCleaned(int x, int y, int dir) {
        int nx = x + dirs[dir][0];
        int ny = y + dirs[dir][1];
        
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return false;
        }
        
        if(map[nx][ny] == 1) {
            return false;
        }
        
        if(cleaned[nx][ny]) {
            return false;
        }

        return true;
    }
    
}