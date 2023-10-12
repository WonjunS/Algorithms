class Solution {
    
    private static final int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] Dy = new int[m][n][2];
        
        Dy[0][0][0] = 0;
        Dy[0][0][1] = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // left -> right
                if(j >= 1) {
                    int x = cityMap[i][j - 1];
                    
                    if(x == 0) {
                        Dy[i][j][0] += (Dy[i][j - 1][0] + Dy[i][j - 1][1]) % MOD;
                    } else if(x == 1) {
                        Dy[i][j][0] = 0;
                    } else {
                        Dy[i][j][0] += (Dy[i][j - 1][0]) % MOD;
                    }
                }
                
                // up -> down
                if(i >= 1) {
                    int y = cityMap[i - 1][j];
                    
                    if(y == 0) {
                        Dy[i][j][1] += (Dy[i - 1][j][0] + Dy[i - 1][j][1]) % MOD;
                    } else if(y == 1) {
                        Dy[i][j][1] = 0;
                    } else {
                        Dy[i][j][1] += (Dy[i - 1][j][1]) % MOD;
                    }
                }
            }
        }
        
        int answer = (Dy[m - 1][n - 1][0] + Dy[m - 1][n - 1][1]) % MOD;
        
        return answer;
    }
    
}