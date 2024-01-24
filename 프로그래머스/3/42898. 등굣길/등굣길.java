class Solution {
    
    private static final int mod = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] DP = new int[n][m];
        
        DP[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isPuddle(i, j, puddles)) {
                    DP[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0) continue;
                if(i == 0 && j != 0) {
                    DP[i][j] = DP[i][j - 1];
                    continue;
                }
                if(i != 0 && j == 0) {
                    DP[i][j] = DP[i - 1][j];
                    continue;
                }
                
                DP[i][j] = (DP[i - 1][j] + DP[i][j - 1]) % mod;
            }
        }
        
        return DP[n - 1][m - 1];
    }
    
    private static boolean isPuddle(int x, int y, int[][] puddles) {
        for(int i = 0; i < puddles.length; i++) {
            if(puddles[i][1] == x + 1 && puddles[i][0] == y + 1) return true;
        }
        
        return false;
    }
}