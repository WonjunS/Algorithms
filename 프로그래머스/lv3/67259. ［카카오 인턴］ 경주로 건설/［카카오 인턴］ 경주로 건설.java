class Solution {
    
    static int N, M;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(int[][] board) {
        N = board.length;
        M = board[0].length;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 1) continue;
                board[i][j] = Integer.MAX_VALUE - 1000;
            }
        }
        
        dfs(board, 0, 0, 0, 0);
        
        return board[N - 1][M - 1];
    }
    
    static void dfs(int[][] board, int dir, int sum, int i, int j) {
        if(i < 0 || j < 0 || i >= N || j >= M ||
          board[i][j] == 1 || board[i][j] + 500 < sum) return;
        
        board[i][j] = Math.min(board[i][j], sum);
        
        for(int k = 0; k < 4; k++) {
            if(i == 0 && j == 0) {
                dfs(board, k, sum + 100, i + dirs[k][0], j + dirs[k][1]);
                continue;
            }
            if(dir == k) dfs(board, k, sum + 100, i + dirs[k][0], j + dirs[k][1]);
            else dfs(board, k, sum + 600, i + dirs[k][0], j + dirs[k][1]);
        }
    }
}