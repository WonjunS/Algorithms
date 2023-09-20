class Solution {
    
    private static final int MOD = 1000000007;
    
    public int solution(int n) {
        int[] DP = new int[n + 1];
        
        DP[1] = 1;
        DP[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            DP[i] = (DP[i - 2] + DP[i - 1]) % MOD;
        }
        
        return DP[n];
    }
}