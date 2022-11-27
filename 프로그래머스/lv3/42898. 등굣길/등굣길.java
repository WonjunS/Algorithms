class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] Dy = new int[n + 1][m + 1];
        int mod = 1000000007;
        
        for(int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            
            Dy[y][x] = -1;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1 && j == 1) {
                    Dy[i][j] = 1;
                    continue;
                }
                if(Dy[i][j] == -1) {
                    Dy[i][j] = 0;
                    continue;
                }
                Dy[i][j] = (Dy[i][j - 1] + Dy[i - 1][j]) % mod;
            }
        }
        
        int answer = Dy[n][m];
        
        return answer;
    }
}