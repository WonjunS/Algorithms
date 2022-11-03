import java.util.*;

class Solution {
    
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, 
                          {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
                          {2, 0}, {0, 2}, {-2, 0}, {0, -2}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            boolean[][] visit = new boolean[5][5];
            boolean run = true;
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(!visit[j][k] && places[i][j].charAt(k) == 'P') {
                        run = bfs(j, k, visit, places[i]);
                    }
                    if(!run) break;
                }
                if(!run) break;
            }
            if(run) answer[i] = 1;
            if(!run) answer[i] = 0;
        }
        
        return answer;
    }
    
    static boolean bfs(int a, int b, boolean[][] visit, String[] room) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        q.add(b);
        visit[a][b] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for(int i = 0; i < 12; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(room[nx].charAt(ny) == 'O' || room[nx].charAt(ny) == 'X') continue;
                if(visit[nx][ny]) continue;
                
                int dist = Math.abs(nx - x) + Math.abs(ny - y);
                if(dist > 2) {
                    visit[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    continue;
                }
                if(dist == 1) return false;
                if(dist == 2) {
                    if(nx == x) {
                        int mid = (y + ny) / 2;
                        if(room[x].charAt(mid) == 'X') {
                            visit[nx][ny] = true;
                            q.add(nx);
                            q.add(ny);
                            continue;
                        }
                        else return false;
                    }
                    if(ny == y) {
                        int mid = (x + nx) / 2;
                        if(room[mid].charAt(y) == 'X') {
                            visit[nx][ny] = true;
                            q.add(nx);
                            q.add(ny);
                            continue;
                        }
                        else return false;
                    }
                    else {
                        if(room[nx].charAt(y) == 'X' && room[x].charAt(ny) == 'X') {
                            visit[nx][ny] = true;
                            q.add(nx);
                            q.add(ny);
                            continue;
                        }
                        else return false;
                    }
                }
            }
        }
        return true;
    }
}