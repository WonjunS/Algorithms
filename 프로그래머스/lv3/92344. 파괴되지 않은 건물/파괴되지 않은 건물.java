class Solution {
    
    static int type, r1, c1, r2, c2, deg;
    
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N + 1][M + 1];
        
        for(int i = 0; i < skill.length; i++) {
            type = skill[i][0];
            r1 = skill[i][1];
            c1 = skill[i][2];
            r2 = skill[i][3];
            c2 = skill[i][4];
            deg = skill[i][5];
            
            if(type == 1) {
                sum[r1][c1] -= deg;
                sum[r1][c2 + 1] += deg;
                sum[r2 + 1][c1] += deg;
                sum[r2 + 1][c2 + 1] -= deg;
            }
            if(type == 2) {
                sum[r1][c1] += deg;
                sum[r1][c2 + 1] -= deg;
                sum[r2 + 1][c1] -= deg;
                sum[r2 + 1][c2 + 1] += deg;
            }
        }
        
        int answer = 0;
        for(int i = 0; i <= N; i++) {
            int S = 0;
            for(int j = 0; j <= M; j++) {
                S += sum[i][j];
                sum[i][j] = S;
            }
        }
        
        for(int i = 0; i < M; i++) {
            int S = 0;
            for(int j = 0; j < N; j++) {
                S += sum[j][i];
                sum[j][i] = S;
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(sum[i][j] + board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}