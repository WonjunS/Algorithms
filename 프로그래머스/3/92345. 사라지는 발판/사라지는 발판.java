class Solution {
    
    private static int N, M, answer;
    private static char[][] map;
    private static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        
        map = new char[N][M];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                map[i][j] = (board[i][j] == 1) ? '1' : '0';
            }
        }
        
        int answer = dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
        
        return answer;
    }
    
    private static int dfs(int ax, int ay, int bx, int by) {
        if(map[ax][ay] == '0') {
            return 0;
        }
        
        int result = 0;
        
        for(int i = 0; i < 4; i++) {
            int nx = ax + dirs[i][0];
            int ny = ay + dirs[i][1];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] == '0') continue;
            
            map[ax][ay] = '0';
            
            int value = dfs(bx, by, nx, ny) + 1;
            
            map[ax][ay] = '1';
            
            if(value % 2 == 1 && result % 2 == 0) {
                result = value;
            } else if(value % 2 == 0 && result % 2 == 0) {
                result = Math.max(value, result);
            } else if(value % 2 == 1 && result % 2 == 1) {
                result = Math.min(value, result);
            }
        }
        
        return result;
    }

}