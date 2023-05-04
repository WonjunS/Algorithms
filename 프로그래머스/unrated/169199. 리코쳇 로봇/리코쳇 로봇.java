import java.util.*;

class Solution {
    
    static class Info {
        private int x;
        private int y;
        private int count;
        
        public Info(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    static int N, M, start_x, start_y, dest_x, dest_y;
    static boolean[][] visit;
    static char[][] map;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                char c = board[i].charAt(j);
                if(c == 'R') {
                    start_x = i;
                    start_y = j;
                }
                if(c == 'G') {
                    dest_x = i;
                    dest_y = j;
                }
                map[i][j] = c;
            }
        }
        
        if(!isSurrounded()) {
            return -1;
        }
        
        int answer = bfs();
        
        return answer;
    }
    
    static int bfs() {
        PriorityQueue<Info> pq = 
            new PriorityQueue<>((o1, o2) -> (o1.count - o2.count));
        
        pq.add(new Info(start_x, start_y, 0));
        
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            int curr_x = info.x;
            int curr_y = info.y;
            int cnt = info.count;
            
            if(curr_x == dest_x && curr_y == dest_y) {
                return cnt;
            }
            
            if(visit[curr_x][curr_y]) continue;
            
            visit[curr_x][curr_y] = true;
            
            for(int i = 0; i < 4; i++) {
                int rx = move[i][0];
                int ry = move[i][1];
                
                int nx = curr_x, ny = curr_y;
                while(true) {
                    if(nx == 0 && ny == 0 && map[nx][ny] != 'D') {
                        if(i == 2 || i == 3) {
                            pq.add(new Info(nx, ny, cnt + 1));
                            break;
                        }
                    }
                    if(nx == 0 && ny == M - 1 && map[nx][ny] != 'D') {
                        if(i == 1 || i == 2) {
                            pq.add(new Info(nx, ny, cnt + 1));
                            break;
                        }
                    }
                    if(nx == N - 1 && ny == 0 && map[nx][ny] != 'D') {
                        if(i == 0 || i == 3) {
                            pq.add(new Info(nx, ny, cnt + 1));
                            break;
                        }
                    }
                    if(nx == N - 1 && ny == M - 1 && map[nx][ny] != 'D'){
                        if(i == 0 || i == 1) {
                            pq.add(new Info(nx, ny, cnt + 1));
                            break;
                        }
                    }
                    
                    if(i == 0 && nx == N - 1 && map[nx][ny] != 'D') {
                        pq.add(new Info(nx, ny, cnt + 1));
                        break;
                    }
                    if(i == 1 && ny == M - 1 && map[nx][ny] != 'D') {
                        pq.add(new Info(nx, ny, cnt + 1));
                        break;
                    }
                    if(i == 2 && nx == 0 && map[nx][ny] != 'D') {
                        pq.add(new Info(nx, ny, cnt + 1));
                        break;
                    }
                    if(i == 3 && ny == 0 && map[nx][ny] != 'D') {
                        pq.add(new Info(nx, ny, cnt + 1));
                        break;
                    }
                    
                    if(map[nx][ny] == 'D') {
                        pq.add(new Info(nx - rx, ny - ry, cnt + 1));
                        break;
                    }
                    nx += rx;
                    ny += ry;
                }
            }
        }
        
        return -1;
    }
    
    private static boolean isSurrounded() {
        for(int i = 0; i < 4; i++) {
            int nx = dest_x + move[i][0];
            int ny = dest_y + move[i][1];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) return true;
            if(map[nx][ny] == 'D') return true;
        }
        
        return false;
    }

}