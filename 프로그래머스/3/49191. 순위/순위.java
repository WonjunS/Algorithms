class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] wins = new boolean[n + 1][n + 1];
        boolean[][] loses = new boolean[n + 1][n + 1];
        
        for(int[] result : results) {
            wins[result[0]][result[1]] = true;
            loses[result[1]][result[0]] = true;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(wins[i][j] == true && wins[j][k] == true) {
                        wins[i][k] = true;
                        loses[k][i] = true;
                    }
                    if(loses[i][j] == true && loses[j][k] == true) {
                        loses[i][k] = true;
                        wins[k][i] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int tmp = 0;
            for(int j = 1; j <= n; j++) {
                if(wins[i][j] == true || loses[i][j] == true) tmp++;
            }
            
            if(tmp == n - 1) answer++;
        }
        
        return answer;
    }
}