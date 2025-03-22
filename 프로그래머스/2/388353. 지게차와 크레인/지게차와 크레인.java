import java.util.*;

class Solution {
    
    private static int n, m, answer;
    private static boolean flag;
    private static boolean[][] visit;
    private static char[][] map;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n][m];
        answer = n * m;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char c = storage[i].charAt(j);
                map[i][j] = c;
            }
        }
        
        for(String request : requests) {
            if(request.length() == 1) {
                option1(request.charAt(0));
            } else {
                option2(request.charAt(0));
            }
        }
        
        return answer;
    }
    
    // 지게차 사용
    private static void option1(char type) {
        List<int[]> list = new ArrayList<>();
        
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                char currType = map[x][y]; // 컨테이너 종류
                flag = false; // 접근 가능 여부
                visit = new boolean[n][m];
                checkReachable(x, y);
                
                if(flag && type == currType) {
                    list.add(new int[]{x, y});
                }
            }
        }
        
        removeContainers(list);
    }
    
    // 크레인 사용
    private static void option2(char type) {
        List<int[]> list = new ArrayList<>();
        
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                char currType = map[x][y];
                if(currType == type) {
                    list.add(new int[]{x, y});
                }
            }
        }
        
        removeContainers(list);
    }
    
    // 컨테이너 출고
    private static void removeContainers(List<int[]> list) {
        for(int[] coords : list) {
            int x = coords[0];
            int y = coords[1];
            
            map[x][y] = '-';
            answer--;
        }
    }
    
    private static void checkReachable(int x, int y) {
        if(flag) return;
        
        if(x < 0 || y < 0 || x >= n || y >= m) {
            flag = true;
            return;
        }
        
        visit[x][y] = true;
        
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if(nx >= 0 && ny >= 0 && nx <= (n - 1) && ny <= (m - 1)) {
                if(visit[nx][ny]) continue;
                
                if(map[nx][ny] == '-') {
                    checkReachable(nx, ny);
                }
            } else {
                flag = true;
                return;
            }
        }
    }
}